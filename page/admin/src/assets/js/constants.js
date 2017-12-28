/**
 * 用户状态数据字典
 */
export const UserStatus={
	INIT:{value:0,label:'INIT',text:'未激活'},
	ACTIVATED:{value:1,label:'ACTIVATED',text:'已激活'},
	LOCKED:{value:2,label:'LOCKED',text:'锁定'},
	DISABLED:{value:3,label:'DISABLED',text:'禁用'},
	list:[
		{value:0,label:'INIT',text:'未激活'},
		{value:1,label:'ACTIVATED',text:'已激活'},
	    {value:2,label:'LOCKED',text:'锁定'},
	    {value:3,label:'DISABLED',text:'禁用'},
	]
}

/**
 * 评论主题类型
 */
export const CommentTopic={
	ARTICLE:{value:0,label:'ARTICLE',text:'文章'},
	COMMENT:{value:1,label:'COMMENT',text:'评论'},
	SITE:{value:2,label:'SITE',text:'站点'},
	TOOL:{value:3,label:'TOOL',text:'工具'},
	list:[
		{value:0,label:'ARTICLE',text:'文章'},
		{value:1,label:'COMMENT',text:'评论'},
	    {value:2,label:'SITE',text:'站点'},
	    {value:3,label:'TOOL',text:'工具'},
	]
}

/**
 * 系统常量
 */
export const SystemConstants ={
	// 默认用户头像地址
	DEFAULT_USER_AVATAR:'http://127.0.0.1/user-avatar.png'
}
