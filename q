[33mcommit f7ed104647f5254fb63987cee5007b1374543356[m[33m ([m[1;36mHEAD -> [m[1;32mfeature_registerlogin[m[33m)[m
Author: wezzlaren <wesley2810@hotmail.com>
Date:   Thu Feb 13 20:11:06 2020 +0100

     fix able to retrieve register postdata, but does not insert in db, value is null

[33mcommit a7dd2d72325c6fb92f07bc0c8811ed45e2626822[m[33m ([m[1;31morigin/feature_registerlogin[m[33m)[m
Author: wezzlaren <wesley2810@hotmail.com>
Date:   Thu Feb 13 14:36:01 2020 +0100

    add gson to userRegister

[33mcommit db5c88c0bac5941d4e7bf286e87dfd229d4e90bb[m
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Thu Feb 13 11:29:05 2020 +0100

    registration of user

[33mcommit d9b7d1baaae669b688f2832d4f59ed19d0fc0412[m
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Thu Feb 13 09:51:27 2020 +0100

    registration endpoint

[33mcommit 0684fffcfaa9551f3dd4e68be4bb41b12a956462[m
Author: wezzlaren <wesley2810@hotmail.com>
Date:   Thu Feb 13 09:37:14 2020 +0100

    set list

[33mcommit 87b7a7b79b7db0845a6e72dfd4d3458bb592e489[m[33m ([m[1;32mfeature_statuscontroller[m[33m)[m
Author: Bas van den Eertwegh <b.vandeneertwegh@student.fontys.nl>
Date:   Thu Feb 13 09:06:31 2020 +0100

    year and threemonths should be functional

[33mcommit 6996d74dcdada39ed5f5eef6eb6acf2515ddfda2[m
Author: Bas van den Eertwegh <b.vandeneertwegh@student.fontys.nl>
Date:   Wed Feb 12 16:17:32 2020 +0100

    year threemonths are done

[33mcommit 442e220f5663f0df26e8ccc5d2b412e6958f024d[m
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Wed Feb 12 15:27:19 2020 +0100

    get status from user

[33mcommit de1c5c1cd382507510846284f1e879e93df366ec[m
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Wed Feb 12 14:04:12 2020 +0100

    Get status from user

[33mcommit e602986b6a7b2ba9c11f3daf4c416ac741d4a634[m
Merge: 71705c5 007d29e
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Wed Feb 12 13:52:59 2020 +0100

    Merge branch 'feature_statuscontroller' of https://github.com/JorisWijnen/Corona-Energy-Grid-Backend into feature_statuscontroller
    
     Conflicts:
    	src/main/java/com/corona/backend/BackendApplication.java
    	src/main/java/com/corona/backend/controllers/StatusController.java
    	src/main/java/com/corona/backend/services/StatusService.java

[33mcommit 007d29edaacb7186ea8af76836f964f0190beb5e[m
Author: wezzlaren <wesley2810@hotmail.com>
Date:   Wed Feb 12 13:51:12 2020 +0100

     add getCurrentuser

[33mcommit 71705c50dc97fec71edccd2dafa6c94eff352716[m
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Wed Feb 12 12:49:21 2020 +0100

    get status by id

[33mcommit 81f61954d72c78f83d238afbe3d3e8678801bf0f[m
Author: tcskrijnen <tim.krijnen9@gmail.com>
Date:   Wed Feb 12 12:42:44 2020 +0100

    Service for StatusService

[33mcommit ef7d66db1102fcdb27a54334bb7627517530ecc5[m
Author: wesley <wesley2810@hotmail.com>
Date:   Wed Feb 12 12:36:18 2020 +0100

    add beans

[33mcommit 6018a2b11561631eb3bc0410c0191fcfe2cbe2c1[m
Author: wesley <wesley.vercoulen@fontys.nl>
Date:   Wed Feb 12 11:03:32 2020 +0100

    added statuscontroller

[33mcommit 4762cd83a995b01bb674d8a95b0e56b257a07edb[m
Merge: b43720c 16e49c1
Author: wesley <wesley.vercoulen@fontys.nl>
Date:   Wed Feb 12 09:17:38 2020 +0100

    Merge branch 'feature_models_dtos' into develop

[33mcommit 16e49c19eb2c5caf839a8301f9f3f389e0737e36[m[33m ([m[1;31morigin/feature_models_dtos[m[33m, [m[1;32mfeature_models_dtos[m[33m)[m
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Tue Feb 11 15:31:51 2020 +0100

    Add fields

[33mcommit 8e9af64e33f248b164210ccb1a30876182681192[m
Author: wesley <wesley.vercoulen@fontys.nl>
Date:   Tue Feb 11 15:05:39 2020 +0100

     add status model+dto+repository

[33mcommit 400924c5f736f96658104282c3d240d70390a47b[m
Author: wesley <wesley.vercoulen@fontys.nl>
Date:   Tue Feb 11 13:36:02 2020 +0100

     add user+register dto, added propertities to user, removed username

[33mcommit b43720c01e00c17db20c48820024afe11a60b58e[m
Merge: 32ce65d 3441724
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Tue Feb 11 12:44:10 2020 +0100

    Merge branch 'develop' of https://github.com/JorisWijnen/Corona-Energy-Grid-Backend into develop

[33mcommit 32ce65dc0437fce72ccadb292f2427f87588e9dc[m
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Tue Feb 11 12:41:50 2020 +0100

    application properties

[33mcommit 34417245c1a7794d3db7a39c19a27948779fa4e6[m
Merge: eac5eff e85189d
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Tue Feb 11 12:31:21 2020 +0100

    Merge pull request #4 from JorisWijnen/feature_base_demo
    
    Feature base demo

[33mcommit e85189d0c03fec2147c3a65b18f4a6cd1da37c26[m[33m ([m[1;31morigin/feature_base_demo[m[33m)[m
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Tue Feb 11 12:27:57 2020 +0100

    mock data

[33mcommit 1a62d6a7c9efa66961f3950781c98bb5a138a3f3[m
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Tue Feb 11 12:03:18 2020 +0100

    demo project

[33mcommit 7e69fee6daecf7dee365d2c8cad877de231d2131[m
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Tue Feb 11 11:55:02 2020 +0100

    test

[33mcommit eac5effdaf08c76861c76bc5f3ebb53b959905f9[m
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Tue Feb 11 11:40:31 2020 +0100

    Add file structure

[33mcommit 8dfebd64cca7795275b4b76417293f80c06ba5a2[m
Merge: 42361f5 2e8d24b
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Tue Feb 11 11:35:04 2020 +0100

    resolve merge conflict

[33mcommit 2e8d24bbb136bd7dfe8f00bd27f88504c777ed96[m[33m ([m[1;31morigin/master[m[33m, [m[1;31morigin/HEAD[m[33m)[m
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Tue Feb 11 11:33:08 2020 +0100

    init

[33mcommit 42361f5bf18c6230e37e07845bb22b2308778e9c[m
Merge: f62971d e66b004
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Tue Feb 11 11:21:34 2020 +0100

    Merge branch 'develop' of https://github.com/JorisWijnen/Corona-Energy-Grid into develop

[33mcommit f62971ddacd7ec2bea07e0d078dd64c7f0eebe8a[m
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Tue Feb 11 11:21:26 2020 +0100

    project init

[33mcommit 4f071678eb9129fa7f5dbb48a296231a103b4b73[m
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Mon Feb 10 11:55:07 2020 +0100

    Update README.md

[33mcommit 1af375eb56ecf83268052b63f01eeec676960b05[m
Merge: be561ee e66b004
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Mon Feb 10 11:29:08 2020 +0100

    Merge pull request #3 from JorisWijnen/develop
    
    Develop

[33mcommit e66b004362653fc9225ca50230edf2293412bdba[m
Merge: 8fb3b0f eca87e5
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Mon Feb 10 11:28:03 2020 +0100

    Merge pull request #2 from JorisWijnen/feature_readme
    
    bas toegevoegd

[33mcommit eca87e518ae8587cbd853e37b2b390f02783f916[m[33m ([m[1;31morigin/feature_readme[m[33m)[m
Author: Bas van den Eertwegh <b.vandeneertwegh@student.fontys.nl>
Date:   Mon Feb 10 11:25:35 2020 +0100

    bas toegevoegd

[33mcommit be561ee5b72c86d540b0bf1f7dfa9d83d8e3829d[m[33m ([m[1;32mmaster[m[33m)[m
Author: Wijnen,Joris J <joris.wijnen@student.fontys.nl>
Date:   Mon Feb 10 11:19:53 2020 +0100

    update README

[33mcommit 8fb3b0f9acaa15c090ae1d088051ad11469726ca[m
Author: Lotte Diesveld <l.diesveld@student.fontys.nl>
Date:   Mon Feb 10 11:09:53 2020 +0100

    Update README.md

[33mcommit 11a7d02b2a1cdcbeec717038ab216955fe4dfb07[m
Author: tcskrijnen <37795939+tcskrijnen@users.noreply.github.com>
Date:   Mon Feb 10 11:05:23 2020 +0100

    Update README.md

[33mcommit 5bcad0b6b05691505664cb3be870179f0a902ed2[m
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Mon Feb 10 11:05:06 2020 +0100

    Update README.md

[33mcommit ff07db15e27e4e9eb66e93cba3fa81a0146b498f[m
Author: victorvanleeuwen <v.vn.leeuwen@gmail.com>
Date:   Mon Feb 10 11:01:32 2020 +0100

    Update README.md

[33mcommit 91917673f16fea89610f9d2490adeed9446a6a5d[m
Author: wezzlaren <31407139+wezzlaren@users.noreply.github.com>
Date:   Mon Feb 10 10:57:29 2020 +0100

    Update Readme

[33mcommit bc7c99a851242cadef210caeaad41eb4a54586ae[m
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Mon Feb 10 10:53:33 2020 +0100

    Update README.md

[33mcommit bff1ba16ef70bf4ea83779b64d3217b88594254d[m
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Mon Feb 10 10:51:27 2020 +0100

    Update README.md

[33mcommit 3b8f1c391db4bdc43b3088f0837c8d39a3feaea4[m
Author: Joris Wijnen <joris.wijnen97@gmail.com>
Date:   Mon Feb 10 10:21:58 2020 +0100

    Initial commit
