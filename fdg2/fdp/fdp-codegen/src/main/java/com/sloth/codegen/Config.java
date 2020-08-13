package com.sloth.codegen;

public class Config {
	private String projectName;// 项目名称（用于生成项目结构，如项目名称为sloth，则生成项目结构为sloth-model及sloth-web）
	private String moduleName;// 模块名称（用于确定sql文件及页面文件放置位置）
	private String modelPkg;// Model包名
	private String baseModelPkg;// BaseModel包名
	private String servicePkg;// Service包名
	private String ctlPkg;// Controller包名
	private String modulePkg;// Module包名
	private String modelDir;// Model存放位置（绝对路径）
	private String baseModelDir;// BaseModel存放位置（绝对路径）
	private String serviceDir;// Service存放位置（绝对路径）
	private String sqlDir;// Sql存放位置（绝对路径）
	private String ctlDir;// Controller存放位置（绝对路径）
	private String viewDir;// View存放位置（绝对路径）
	private String moduleDir;// Module存放位置（绝对路径）
	private String idStrategy;// 表的ID字段生成策略，目前仅支持uuid

	public Config(String projectName) {
		this("com", projectName, projectName);
	}

	public Config(String projectName, String moduleName) {
		this("com", projectName, moduleName);
	}

	public Config(String prefixPkg, String projectName, String moduleName) {
		this.projectName = projectName;
		this.moduleName = moduleName;
		this.modelPkg = prefixPkg + "." + moduleName + ".model";
		this.baseModelPkg = this.modelPkg + ".base";
		this.servicePkg = prefixPkg + "." + moduleName + ".service";
		this.ctlPkg = prefixPkg + "." + moduleName + ".controller";
		this.modulePkg = prefixPkg + "." + moduleName + ".module";
		this.idStrategy = "uuid";
	}

	public Config build(String baseDir) {
		String modelBase = baseDir + projectName + "-model/src/main/";
		String webBase = baseDir + projectName + "-web/src/main/";
		this.modelDir = modelBase + "java/" + modelPkg.replaceAll("\\.", "/");
		this.baseModelDir = modelDir + "/base";
		this.serviceDir = modelBase + "java/" + servicePkg.replaceAll("\\.", "/");
		this.sqlDir = modelBase + "resources/sqlfiles/" + moduleName;
		this.ctlDir = webBase + "java/" + ctlPkg.replaceAll("\\.", "/");
		this.viewDir = webBase + "resources/pages/" + moduleName;
		this.moduleDir = webBase + "java/" + modulePkg.replaceAll("\\.", "/");
		return this;
	}

	public String getModelPkg() {
		return modelPkg;
	}

	public void setModelPkg(String modelPkg) {
		this.modelPkg = modelPkg;
	}

	public String getBaseModelPkg() {
		return baseModelPkg;
	}

	public void setBaseModelPkg(String baseModelPkg) {
		this.baseModelPkg = baseModelPkg;
	}

	public String getServicePkg() {
		return servicePkg;
	}

	public void setServicePkg(String servicePkg) {
		this.servicePkg = servicePkg;
	}

	public String getCtlPkg() {
		return ctlPkg;
	}

	public void setCtlPkg(String ctlPkg) {
		this.ctlPkg = ctlPkg;
	}

	public String getModulePkg() {
		return modulePkg;
	}

	public void setModulePkg(String modulePkg) {
		this.modulePkg = modulePkg;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getModelDir() {
		return modelDir;
	}

	public String getBaseModelDir() {
		return baseModelDir;
	}

	public String getServiceDir() {
		return serviceDir;
	}

	public String getSqlDir() {
		return sqlDir;
	}

	public String getCtlDir() {
		return ctlDir;
	}

	public String getViewDir() {
		return viewDir;
	}

	public String getModuleDir() {
		return moduleDir;
	}

	public String getIdStrategy() {
		return idStrategy;
	}

	public void setIdStrategy(String idStrategy) {
		this.idStrategy = idStrategy;
	}
}