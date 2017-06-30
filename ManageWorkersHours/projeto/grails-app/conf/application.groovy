// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'user.SecUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'user.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'user.SecRole'
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'user.PersistentLogin'
grails.plugin.springsecurity.rememberMe.persistent = true


empyeeRole = RoleType.ROLE_EMPYEE.name
admRole = RoleType.ROLE_ADM.name
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
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/manager/**',        access: ['ROLE_ADM', 'IsFullyAuthenticated()']],
		[pattern: '/employer/**',        access: 'ROLE_EMPYEE'],
		[pattern: '/login/**',       access: ['permitAll']],
		[pattern: '/logout/**',      access: ['permitAll']]
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

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/login',          access: ['permitAll']],
		[pattern: '/login/**',       access: ['permitAll']],
		[pattern: '/logout',         access: ['permitAll']],
		[pattern: '/logout/**',      access: ['permitAll']],

		[pattern: '/manager/**',      access: ['ROLE_ADM']],
		[pattern: '/configuration/**',      access: ['ROLE_ADM']],

		[pattern: '/employer/home',      access: ['ROLE_EMPYEE']],
		[pattern: '/employer/**',      access: ['ROLE_ADM', 'ROLE_EMPYEE']],
		[pattern: '/hourregister/create',      access: ['ROLE_EMPYEE']],
		[pattern: '/hourregister/**',      access: ['ROLE_ADM', 'ROLE_EMPYEE']],
]