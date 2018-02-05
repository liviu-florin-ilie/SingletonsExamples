Hello,

Just reading this article https://dzone.com/articles/singleton-pattern-1 and thought I could execute the code presented
there. So, after wandering for a few good hours I managed to make it work.

Also this article helped:
http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/embeddedContainerDemo/EmbeddedContainerDemo.html .

The needed libraries are in the pom.xml. Although lower versions of glassfish-embedded-all gave some headaches as the
container wouldn't instantiate itself (e.g. 3.XXX).

Some other encountered problems
1.
    INFO: HV000001: Hibernate Validator 4.3.0.Final
    Feb 04, 2018 2:56:04 PM com.sun.enterprise.security.ssl.impl.SecuritySupportImpl checkCertificateDates
    SEVERE: SEC5054: Certificate has expired: [
    [
      Version: V3
      Subject: CN=GTE CyberTrust Root 5, OU="GTE CyberTrust Solutions, Inc.", O=GTE Corporation, C=US
      Signature Algorithm: SHA1withRSA, OID = 1.2.840.113549.1.1.5

      Key:  Sun RSA public key, 2048 bits
      modulus: 23741889829347261660812437366387754385443431973861114865490414153884050331745811968523116847625570146592736935209718565296053386842135985534863157983128812774162998053673746470782252407673402238146869994438729551246768368782318393878374421033907597162218758024581735139682087126982809511479059100617027892880227587855877479432885604404402435662802390484099065871430585284534529627347717530352189612077130606642676951640071336717026459037542552927905851171460589361570392199748753414855675665635003335769915908187224347232807336022456537328962095005323382940080676931822787496212635993279098588863972868266229522169377
      public exponent: 65537
      Validity: [From: Fri Aug 14 17:50:00 EEST 1998,
                   To: Thu Aug 15 02:59:00 EEST 2013]
      Issuer: CN=GTE CyberTrust Root 5, OU="GTE CyberTrust Solutions, Inc.", O=GTE Corporation, C=US
      SerialNumber: [    01b6]

    Certificate Extensions: 4
    [1]: ObjectId: 2.5.29.19 Criticality=true
    BasicConstraints:[
      CA:true
      PathLen:5
    ]

    [2]: ObjectId: 2.5.29.32 Criticality=false
    CertificatePolicies [
      [CertificatePolicyId: [1.2.840.113763.1.2.1.3]
    []  ]
    ]

    [3]: ObjectId: 2.5.29.15 Criticality=true
    KeyUsage [
      Key_CertSign
      Crl_Sign
    ]

    [4]: ObjectId: 2.5.29.14 Criticality=false
    SubjectKeyIdentifier [
    KeyIdentifier [
    0000: 76 0A 49 21 38 4C 9F DE   F8 C4 49 C7 71 71 91 9D  v.I!8L....I.qq..
    ]
    ]

    ]
      Algorithm: [SHA1withRSA]
      Signature:
    0000: 41 3A D4 18 5B DA B8 DE   21 1C E1 8E 09 E5 F1 68  A:..[...!......h
    0010: 34 FF DE 96 F4 07 F5 A7   3C F3 AC 4A B1 9B FA 92  4.......<..J....
    0020: FA 9B ED E6 32 21 AA 4A   76 C5 DC 4F 38 E5 DF D5  ....2!.Jv..O8...
    0030: 86 E4 D5 C8 76 7D 98 D7   B1 CD 8F 4D B5 91 23 6C  ....v......M..#l
    0040: 8B 8A EB EA 7C EF 14 94   C4 C6 F0 1F 4A 2D 32 71  ............J-2q
    0050: 63 2B 63 91 26 02 09 B6   80 1D ED E2 CC B8 7F DB  c+c.&...........
    0060: 87 63 C8 E1 D0 6C 26 B1   35 1D 40 66 10 1B CD 95  .c...l&.5.@f....
    0070: 54 18 33 61 EC 13 4F DA   13 F7 99 AF 3E D0 CF 8E  T.3a..O.....>...
    0080: A6 72 A2 B3 C3 05 9A C9   27 7D 92 CC 7E 52 8D B3  .r......'....R..
    0090: AB 70 6D 9E 89 9F 4D EB   1A 75 C2 98 AA D5 02 16  .pm...M..u......
    00A0: D7 0C 8A BF 25 E4 EB 2D   BC 98 E9 58 38 19 7C B9  ....%..-...X8...
    00B0: 37 FE DB E2 99 08 73 06   C7 97 83 6A 7D 10 01 2F  7.....s....j.../
    00C0: 32 B9 17 05 4A 65 E6 2F   CE BE 5E 53 A6 82 E9 9A  2...Je./..^S....
    00D0: 53 0A 84 74 2D 83 CA C8   94 16 76 5F 94 61 28 F0  S..t-.....v_.a(.
    00E0: 85 A7 39 BB D7 8B D9 A8   B2 13 1D 54 09 34 24 7D  ..9........T.4$.
    00F0: 20 81 7D 66 7E A2 90 74   5C 10 C6 BD EC AB 1B C2   ..f...t\.......

    ]
    Feb 04, 2018 2:56:04 PM com.sun.enterprise.v3.services.impl.GrizzlyService createNetworkProxy
    INFO: Network listener http-listener on port 0 disabled per domain.xml
    Feb 04, 2018 2:56:04 PM com.sun.enterprise.v3.services.impl.GrizzlyService createNetworkProxy
    INFO: Network listener https-listener on port 0 disabled per domain.xml
    Feb 04, 2018 2:56:04 PM com.sun.enterprise.v3.server.AppServerStartup run
    INFO: GlassFish Server Open Source Edition 3.1.2 (java_re) startup time : Embedded (380ms), startup services(642ms), total(1,022ms)
    Exception in thread "main" javax.ejb.EJBException: org.jvnet.hk2.component.UnsatisfiedDependencyException: injection failed on com.sun.enterprise.container.common.impl.managedbean.ManagedBeanManagerImpl.compEnvManager with interface com.sun.enterprise.container.common.spi.util.ComponentEnvManager
    	at org.glassfish.ejb.embedded.EJBContainerProviderImpl.createContainer(EJBContainerProviderImpl.java:234)
    	at org.glassfish.ejb.embedded.EJBContainerProviderImpl.createEJBContainer(EJBContainerProviderImpl.java:129)
    	at javax.ejb.embeddable.EJBContainer.createEJBContainer(EJBContainer.java:127)
    	at javax.ejb.embeddable.EJBContainer.createEJBContainer(EJBContainer.java:102)
    	at wonder.around.singletons.LoggerClient.main(LoggerClient.java:21)
    	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    	at java.lang.reflect.Method.invoke(Method.java:498)
    	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
    Caused by: org.jvnet.hk2.component.UnsatisfiedDependencyException: injection failed on com.sun.enterprise.container.common.impl.managedbean.ManagedBeanManagerImpl.compEnvManager with interface com.sun.enterprise.container.common.spi.util.ComponentEnvManager
    	at org.jvnet.hk2.component.InjectionManager.error_injectionException(InjectionManager.java:280)
    	at org.jvnet.hk2.component.InjectionManager.inject(InjectionManager.java:161)
    	at org.jvnet.hk2.component.InjectionManager.inject(InjectionManager.java:93)
    	at com.sun.hk2.component.AbstractCreatorImpl.inject(AbstractCreatorImpl.java:126)
    	at com.sun.hk2.component.ConstructorCreator.initialize(ConstructorCreator.java:91)
    	at com.sun.hk2.component.AbstractCreatorImpl.get(AbstractCreatorImpl.java:82)
    	at com.sun.hk2.component.SingletonInhabitant.get(SingletonInhabitant.java:67)
    	at com.sun.hk2.component.EventPublishingInhabitant.get(EventPublishingInhabitant.java:139)
    	at com.sun.hk2.component.AbstractInhabitantImpl.get(AbstractInhabitantImpl.java:78)
    	at com.sun.enterprise.v3.server.AppServerStartup.run(AppServerStartup.java:340)
    	at com.sun.enterprise.v3.server.AppServerStartup.doStart(AppServerStartup.java:145)
    	at com.sun.enterprise.v3.server.AppServerStartup.start(AppServerStartup.java:136)
    	at com.sun.enterprise.glassfish.bootstrap.GlassFishImpl.start(GlassFishImpl.java:79)
    	at org.glassfish.ejb.embedded.EJBContainerImpl.<init>(EJBContainerImpl.java:104)
    	at org.glassfish.ejb.embedded.EJBContainerProviderImpl.createContainer(EJBContainerProviderImpl.java:219)
    	... 9 more
    Caused by: org.jvnet.hk2.component.UnsatisfiedDependencyException: injection failed on com.sun.enterprise.container.common.impl.ComponentEnvManagerImpl.txManager with interface javax.transaction.TransactionManager
    	at org.jvnet.hk2.component.InjectionManager.inject(InjectionManager.java:157)
    	at org.jvnet.hk2.component.InjectionManager.inject(InjectionManager.java:93)
    	at com.sun.hk2.component.AbstractCreatorImpl.inject(AbstractCreatorImpl.java:126)
    	at com.sun.hk2.component.ConstructorCreator.initialize(ConstructorCreator.java:91)
    	at com.sun.hk2.component.AbstractCreatorImpl.get(AbstractCreatorImpl.java:82)
    	at com.sun.hk2.component.SingletonInhabitant.get(SingletonInhabitant.java:67)
    	at com.sun.hk2.component.EventPublishingInhabitant.get(EventPublishingInhabitant.java:139)
    	at com.sun.hk2.component.AbstractInhabitantImpl.get(AbstractInhabitantImpl.java:78)
    	at org.jvnet.hk2.component.Habitat.getComponent(Habitat.java:798)
    	at com.sun.hk2.component.InjectInjectionResolver.getServiceInjectValue(InjectInjectionResolver.java:147)
    	at com.sun.hk2.component.InjectInjectionResolver.getValue(InjectInjectionResolver.java:88)
    	at org.jvnet.hk2.component.InjectionManager.inject(InjectionManager.java:143)
    	... 22 more

    Solution : create src/main/resources/config/cacerts.jks
            https://stackoverflow.com/questions/18304232/arquillian-embedded-glassfish-certificate-expired/18343639#18343639
            https://stackoverflow.com/questions/18248020/certificate-has-expired-in-log-by-starting-glassfish-3-1-2
            https://stackoverflow.com/questions/18304232/arquillian-embedded-glassfish-certificate-expired/18343639#18343639


