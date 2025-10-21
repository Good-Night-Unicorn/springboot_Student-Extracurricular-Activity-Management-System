export default {
	baseUrl: 'http://localhost:8080/springboot038x57l8/',
	name: '/springboot038x57l8',
	indexNav: [
		{
			name: '活动信息',
			url: '/index/huodongxinxi',
		},
		{
			name: '活动论坛',
			url: '/index/forum'
		}, 
		{
			name: '留言板',
			url: '/index/messages'
		},
	],
	cateList: [
		{
			name: '活动信息',
			refTable: 'huodongfenlei',
			refColumn: 'huodongfenlei',
		},
		{
			name: '活动论坛',
			refTable: 'forumtype',
			refColumn: 'typename',
		},
	]
}
