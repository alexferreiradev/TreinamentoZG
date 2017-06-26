// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'user.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'user.SecRole'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugins.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
grails.plugins.springsecurity.interceptUrlMap = [
		'/timeline':         ['ROLE_USER'],
		'/person/*':         ['IS_AUTHENTICATED_REMEMBERED'],
		'/post/followAjax':  ['ROLE_USER'],
		'/post/addPostAjax': ['ROLE_USER', 'IS_AUTHENTICATED_FULLY'],
		'/**':               ['IS_AUTHENTICATED_ANONYMOUSLY']
]

grails.plugin.springsecurity.rememberMe.persistent = true
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'user.PersistentLogin'
