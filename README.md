# game
lingo game
[![codecov](https://codecov.io/gh/jacocloeteHU/game/branch/master/graph/badge.svg?token=9y3DnvvdKs)](https://codecov.io/gh/jacocloeteHU/game)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.lingo%3Agame&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.lingo%3Agame)


Voor auto deployment heb ik heroku gebruikt waar de lingo game app gebruik van maakt.<br/>
https://lingo-words.herokuapp.com/<br/>

sample api
https://lingo-games.herokuapp.com/game/start spel starten .<br/>
https://lingo-games.herokuapp.com/game/FHM15KfAf8/round  game / gamekey/  en dan ronde waar je in zit<br/>
https://lingo-games.herokuapp.com/game/FHM15KfAf8/round/woord raden van woord<br/>
https://lingo-games.herokuapp.com/game/FHM15KfAf8/round/next next ronde spel kijkt automatisch of je doorgaat of herstart<br/>
<br/>
Er is voor static analysis gebruik gemaakt van Checkstyle, en sonarqube.<br/>
Codecov is gebruikt voor het bepalen van de codecoverage.<br/>
Jacoco is ook gebruikt voor het controleren van de codecov.<br/>
Unit en integratie tests zitten in de tests folder.<br/>
Springboot annotations zijn gebruikt voor depenency injection.<br/>
Packages worden ook automatisch gebuild bij CI en CD.<br/>
