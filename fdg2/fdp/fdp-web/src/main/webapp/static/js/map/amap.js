function layers() {
	var Gaode = L.tileLayer.chinaProvider('GaoDe.Normal.Map', {
        maxZoom: 18,
        minZoom: 5
    });
    var Gaodimgem = L.tileLayer.chinaProvider('GaoDe.Satellite.Map', {
        maxZoom: 18,
        minZoom: 5
    });
    var Gaodimga = L.tileLayer.chinaProvider('GaoDe.Satellite.Annotion', {
        maxZoom: 18,
        minZoom: 5
    });
    var Gaodimage = L.layerGroup([Gaode]);
    return Gaodimage;
}
function encodeGeo(y, x) {
	return GPS.gcj_encrypt(y, x);
}
function decodeGeo(y, x) {
	return GPS.gcj_decrypt(y, x);
}