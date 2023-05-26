Install Bible .bbli files here and then modify src/main/resources/application.yml 
to match the Bible version to be used. 

[src/main/resources/application.yaml]
spring:
  datasource:
    url: jdbc:sqlite::resource:bibles/[REPLACE_WITH_BIBLE_VERSION].bbli

    For example:

    url: jdbc:sqlite::resource:bibles/kjv+.bbli

    The above line will use the kjv+.bbli bible version

Note: If you're on a Mac and have e-Sword already installed, then run the following script
within the project root folder:

./install-kjv+-bible.sh
