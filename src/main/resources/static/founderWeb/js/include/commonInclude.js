/*
 * 公共的引入的js方法
 * 
 */

/**
 * 日期格式化
 * @param date 日期
 * @param filter 格式,例如（yyyy-mm-dd hh:mi:ss）
 * @returns
 */
function getDateStr(date,filter){
	const yyyy = date.getFullYear();
	const mm=(date.getMonth()+1) >= 10 ? date.getMonth()+1 : '0'+(date.getMonth()+1);
	const dd=date.getDate() >= 10 ? date.getDate() : '0'+date.getDate();

	const hh=date.getHours() >= 10 ? date.getHours() : '0'+date.getHours();
	const mi=date.getMinutes() >= 10 ? date.getMinutes() : '0'+ date.getMinutes();
	const ss=date.getSeconds() >= 10 ? date.getSeconds() : '0'+ date.getSeconds();
	
	filter=filter.replace('yyyy',yyyy);
	filter=filter.replace('mm',mm);
	filter=filter.replace('dd',dd);
	filter=filter.replace('hh',hh);
	filter=filter.replace('mi',mi);
	filter=filter.replace('ss',ss);
	
	return filter;
}

/**
 * UUID随机数生成
 * @returns
 */
function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		const r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
		return v.toString(16);
    });
}

const localVersion = getDateStr(new Date(), 'yyyymmddhh');//以日期作为版本号，可通过修改日期格式确定版本号
let basePath = location.origin;//服务的基本路径

//开发
if(basePath == "file://"){
	const currentUrl = location.href;
	basePath = currentUrl.substr(0,currentUrl.lastIndexOf("jwzh-bootstrap-ui")+17);
}

const dictBasePath = basePath + '/js/dict/';//字典js的目录

document.write('\<script src="founderWeb/js/common/jquery.min.js"\>\<\/script\>');//最基本的jquery
document.write('\<script src="founderWeb/js/common/jquery.blockUI.js"\>\<\/script\>');//“加载中”的蒙层
document.write('\<link href="founderWeb/bootstrap/css/bootstrap.min.css" rel="stylesheet" />');//bootstrap样式
document.write('\<script src="founderWeb/bootstrap/js/bootstrap.min.js"\>\<\/script\>');//bootstrap
document.write('\<link href="founderWeb/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />');//bootstrap样式
document.write('\<script src="founderWeb/bootstrap/js/bootstrap-datetimepicker.min.js"\>\<\/script\>');//bootstrap
document.write('\<script src="founderWeb/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"\>\<\/script\>');//bootstrap
document.write('\<script src="founderWeb/js/founder/founder.modal.js"\>\<\/script\>');//基于bootstrap的模态框组件
document.write('\<script src="founderWeb/js/founder/founder.loading.js"\>\<\/script\>');//基于bootstrap和blockUI的加载组件
document.write('\<script src="founderWeb/js/founder/founder.datebox.js"\>\<\/script\>');//基于bootstrap的日期选择
document.write('\<script src="founderWeb/js/founder/founder.dictTools.js"\>\<\/script\>');//基于bootstrap的日期选择
document.write('\<link href="founderWeb/css/base.css" rel="stylesheet" />');//全局基本的css
