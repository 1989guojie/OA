/** 
 * jQuery时间插件
 */
;(function($){
	/** 为jQuery添加对象的方法 */
	$.fn.extend({
		timeRun : function(){
			/** 创建日期 */
			var d = new Date();
			/** 定义数组 */
			var arr = [];
			/** 添加年 */
			arr.push(d.getFullYear() + "年");
			/** 月 */
			arr.push($.calc(d.getMonth() + 1) + "月");
			/** 日 */
			arr.push($.calc(d.getDate()) + "日");
			/** 星期几 0-6 */
			arr.push("&nbsp;" + $.weeks[d.getDay()] + "&nbsp;");
			/** 小时 */
			arr.push($.calc(d.getHours()) + ":");
			/** 分钟 */
			arr.push($.calc(d.getMinutes()) + ":");
			/** 秒 */
			arr.push($.calc(d.getSeconds()));
			
			this.html(arr.join(""));
			
			/** 把this声明局部的变量 */
			var t = this;
			
			window.setTimeout(function(){
				t.timeRun();
			}, 1000);
		}
	});
	/** 为jQuery添加静态的方法 */
	$.extend({
		weeks : ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
		calc : function(str){
			return str > 9 ? str : "0" + str;
		}
	});
})(jQuery);