# kotlin-mybatis-generator-sample
Mybatis GeneratorをKotlinで利用するためのサンプルコード


## バージョン
| 名称 | バージョン |
| ---- | ---- |
| OpenJDK | 17(Amazon Corretto) |
| Kotlin | 1.6.10 |
| SpringBoot | 2.6.6 |
| Gradle | 7.0.2 |
| MySQL | 8.0.30 |
| mybatis-generator | 1.4.1 |
| mybatis-dynamic-sql | 1.4.0 |
| mybatis-spring-boot-starter | 2.2.2 |

Mybatis Generatorの生成だけであれば  
Gradle、MySQL、mybatis-generatorのみで問題ありません  

本プロジェクトにはGeneratorでの生成やSpringBootで実際に利用するためのサンプルコードを含んでいるため  
それらに必要なライブラリも設定されています

詳細は[build.gradle.kts](./build.gradle.kts)を参照してください
