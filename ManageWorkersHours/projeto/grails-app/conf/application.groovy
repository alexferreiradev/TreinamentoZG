// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'user.SecUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'user.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'user.SecRole'
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'user.PersistentLogin'
grails.plugin.springsecurity.rememberMe.persistent = true


// Regras de acesso
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

// Filtros
//grails.plugin.springsecurity.filterChain.filterNames = [
//		'securityContextPersistenceFilter', 'logoutFilter',
//		'authenticationProcessingFilter', 'rememberMeAuthenticationFilter',
//		'anonymousAuthenticationFilter', 'exceptionTranslationFilter',
//		'filterInvocationInterceptor',
//]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
grails.plugin.springsecurity.interceptUrlMap = [
		'/manager/index':         [RoleType.ROLE_ADM],
		'/employer/**':         [RoleType.ROLE_EMPYEE, RoleType.ROLE_ADM],
		'/**':               ['IS_AUTHENTICATED_ANONYMOUSLY'],
]

