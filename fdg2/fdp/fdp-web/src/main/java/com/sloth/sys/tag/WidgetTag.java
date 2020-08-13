package com.sloth.sys.tag;

import java.util.List;

import com.jfinal.aop.Aop;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.template.Directive;
import com.jfinal.template.Engine;
import com.jfinal.template.Env;
import com.jfinal.template.expr.ast.Assign;
import com.jfinal.template.expr.ast.Expr;
import com.jfinal.template.expr.ast.ExprList;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import com.sloth.common.exception.SlothException;
import com.sloth.service.DictService;

public class WidgetTag extends Directive {
	private DictService dictService = Aop.get(DictService.class);
	protected Engine engine;
	private List<?> datas;

	public WidgetTag() {
		engine = new Engine();
		engine.setToClassPathSourceFactory();
		engine.addSharedMethod(new StrKit());
	}

	@Override
	public void setExprList(ExprList exprList) {
		super.setExprList(exprList);
	}

	public void exec(Env env, Scope scope, Writer writer) {
		Kv data = Kv.create();
		String type = "select";
		for (Expr expr : exprList.getExprArray()) {
			if (!(expr instanceof Assign)) {
				String value = expr.toString();
				if (value.contains(",")) {
					String[] tmp = value.split(",");
					if (tmp.length == 3) {
						this.datas = dictService.findByTable(tmp[0], tmp[1], tmp[2]);
					} else {
						throw new SlothException("参数错误！");
					}
				} else {
					this.datas = dictService.subs(value);
				}
			}
		}
		data.set("datas", this.datas);
		for (Expr expr : exprList.getExprArray()) {
			if (expr instanceof Assign) {
				Assign logical = (Assign) expr;
				if (logical.getId().equals("type")) {
					type = logical.getRight().toString();
				} else {
					Object value = logical.getRight().eval(scope);
					if (logical.getId().equals("value")) {
						data.set(logical.getId(), value != null ? value.toString() : null);
					} else {
						data.set(logical.getId(), value);
					}
				}
			}
		}
		String tpl;
		switch (type) {
		case "radio":
			tpl = "/common/widget/radio.html";
			break;
		case "render":
			tpl = "/common/widget/render.html";
			break;
		default:
			tpl = "/common/widget/select.html";
			break;
		}
		String ret = engine.getTemplate(tpl).renderToString(data);
		write(writer, ret);
	}
}
