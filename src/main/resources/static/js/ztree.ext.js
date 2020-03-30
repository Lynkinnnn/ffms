
/**
 * 构造ZTree
 * @param container tree容器
 */
function ZTree(container) {
	this.container = container;
}

/**
 * 创建ZTree
 * @param container tree容器
 */
ZTree.create = function(container) {
	return new ZTree(container);
}

ZTree.prototype = {
	constructor : ZTree, //构造器
	container : null,  //容器
	tree : null,  //ztree
	data : null, //数据
	expandId : null, //要展开的节点ID
	//ztree配置
	setting : {
		data : {
			simpleData : {
				enable : true,
				idKey : 'id' ,
				pIdKey : 'parentId'
			}
		},
		view : {
			selectedMulti : false,
			dblClickExpand : true
		},
		async : {
			enable : false
		},
		check : {
			enable : false
		},
		callback : {

		}
	},
	/**
	 * 同步树
	 * @param data 树数据
	 */
	sync : function(data) {
		this.setting.async.enable = false;
		this.data = data;
		return this;
	},
	/**
	 * 异步树
	 * @param url 异步url
	 * @param autoParam 参数
	 */
	async : function(url, autoParam) {
		this.setting.async.enable = true;
		this.setting.async.url = url;
		this.setting.async.autoParam = autoParam;
		return this;
	},
	/**
	 * 节点支持checkbox
	 * @param chkboxType 父子节点勾选关联关系，缺省为{"Y": "ps", "N": "ps"}
	 */
	check : function (chkboxType) {
		this.setting.check.enable = true;
		this.setting.check.chkStyle = 'checkbox';
		this.setting.check.chkboxType =  chkboxType || {"Y": "ps", "N": "ps"};
		return this;
	},
	/**
	 * 节点支持radio
	 * @param radioType radio 的分组范围,缺省为 'all',即整棵树为一个分组。
	 */
	radio : function(radioType) {
		this.setting.check.enable = true;
		this.setting.check.chkStyle = 'radio';
		this.setting.check.radioType = radioType || 'all';
		return this;
	},
	/**
	 * 默认展开节点
	 * @param id 要展开的节点ID
	 */
	expand : function(id) {
		this.expandId = id;
		if(this.tree) {
			if (!this.expandId) {
				return false;
			}
			var node = this.tree.getNodesByParam('id', this.expandId, null);
			if (!node || node.length == 0) {
				return false;
			}
			this.tree.expandNode(node[0], true, false, true);
		}
		return this;
	},
	/**
	 * 回调函数
	 * @param onclick 单击回调函数
	 * @param others 其他回调函数。 格式:
	 * {
	 * 		onDblClick : function(){
	 *
	 * 		}
	 * }
	 */
	callBack : function(onclick, others) {
		if(others) {
			$.extend(true, this.setting.callback, others);
		}
		if(onclick && typeof onclick == 'function') {
			this.setting.callback.onClick = onclick;
		}
		return this;
	},
	/**
	 * 初始化树
	 */
	init : function(otherSetting) {
		if (otherSetting) {
			$.extend(true, this.setting, otherSetting);
		}
		this.tree = $.fn.zTree.init($('#' + this.container), this.setting, this.data);
		this.expand(this.expandId);
		return this;
	}
}
