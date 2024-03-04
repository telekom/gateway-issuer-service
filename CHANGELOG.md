# Changelog

## [1.11.1](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/compare/1.11.0...1.11.1) (2024-03-01)


### 🦊 CI/CD

* spring boot 3, switch to netty, actuator endpoint to default path ([8e192c6](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/8e192c67d15f517bc456eac047d230bd6dff509f))


### Other

* added license-info to changelog ([b543751](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/b543751761d3179c95d8fdc65b05c614fc52f477))
* correct license for generated changelog file; fix reuse-config ([1e27a12](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/1e27a12a07f5a18d992361a3e4d7858f9f24c861))
* **release:** 1.11.0 ([7ad7536](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/7ad753657fdb4f972a404a9f3313ea3cf2341846))
* **reuse:** updated name ([3dd35a6](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/3dd35a6943eefda277315949bac21b75b1c4c27c))

## [1.11.0](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/compare/1.10.0...1.11.0) (2024-02-26)


### 📔 Docs

* fix script encoding of hashes, updated examples ([133cd9b](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/133cd9bcdd2c9f74fbf00fc422d08a0411bac639))


### 🦊 CI/CD

* **DHEI-14954:** improvements for docker-build and docs ([8a02aa6](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/8a02aa614c589808ee6bb014365a6c800b255f96))
* added gitlab-pull job ([ed5197d](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/ed5197d8329c6a056bc62545c21fefc6ab781fdf))
* added job to push to proxy repo ([1524d42](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/1524d427f6e112b9171919aa24db2b907cf3d86b))
* added local push to gitlab-pull ([d687afe](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/d687afebd3089e049cfd385af962711d32a32068))
* added m2 to gitignore so reuse ignores it in pipeline; added initial merge-back job ([d49464d](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/d49464d32d38f40bd66b7a5d6b3843b8a181c8d1))
* fix github-sync ([d3e5659](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/d3e565918fd55b4c34671540d58338fc4436d897))
* fixed yaml ([931b2c2](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/931b2c21e8f2c4bbc653f7cebcdc3f518ee65174))
* fixing github-sync job ([79eb049](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/79eb049846a7af1af255f49be8774b4ae26f1c3f))
* fixing github-sync job ([979d0c9](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/979d0c9d2e22800bea94b6c4e9cdf39144002f77))
* fixing github-sync job ([04a40a0](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/04a40a06779db2807d463cd251efe2b33e34adc7))
* fixing gitlab-pull ([d47765f](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/d47765f3f40d6a59410e6bbe93231b4a219a1e15))
* gitlab-sync with custom target branch ([9bd0161](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/9bd0161d2779d0296f12b35e96808a5f33fd7e49))
* moved opensource logic to template ([9e14881](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/9e1488111b358299c6bc156315c3f55ea4b945ab))
* new jobs can only be triggered in proxy-repo ([b6a83f5](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/b6a83f5228049c9c26072db1238c321718ff8c84))
* renamed job github-push ([b764003](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/b7640030c736ddb136f0fb1de4af45c7b13636a6))
* updated pipeline ref to 16.1.0 ([d1f278a](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/d1f278a73bed5f4f6f0966622126cac24bfea8b4))
* using custom access token for merge-back ([4959da5](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/4959da5716bfc274a5ac735f75e9ca91e3c5868b))
* using merge-strategy theirs ([4528fc7](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/4528fc708ba6c8024f808d7f34d98c6c32d29d31))


### 🚀 Features

* create pre-licensed empty .gitignore ([59c7f43](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/59c7f43763017cbeb693cf33eb26d87d2805ed2c))


### Other

* added license info using reuse; updated pipeline ([24d1995](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/24d1995c5ebb243014acf1e8ec5ffb81a949aedb))
* initial commit ([7f54289](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/7f542890be768beb954d2a91c4440262f8c8602c))
* initial commit for github ([5c669f5](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/5c669f56a1bfaf44639491eaf1eb6eb606a0197f))
* merge-back from github ([854f81f](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/854f81f41db90b0b15773d6797f1a224addebc0c))
* sync from gitlab ([0dde997](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/0dde997733de1044ee80651f7d38780a06396b30))
* sync from gitlab ([9f8128a](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/9f8128a50bea282b81fb400c68d2452a10c5a918))

## [1.10.0](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/compare/1.9.0...1.10.0) (2023-11-07)


### 💈 Style

* imports shuffle ([cb87463](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/cb87463f30594c394175065105d88cc1ac7bf5dd))


### 📔 Docs

* test values to readme ([8539aa8](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/8539aa88dd136b7990892a2f1cfc5e96446c0398))


### 🙅‍♂️ Reverts

* dcff84783ec9d6de9c11d52e0e7c67627ee3fee0 ([96c78ec](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/96c78ec76cc0c6a733de2030126d364b87c7bbd8))


### 🚀 Features

* added key script, jjwt to 0.11, remove validation for userInfo ([5ad8f01](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/5ad8f01ed3e9617be1e97bfbb265cac5b4dc8113))


### Other

* set version to 1.9.0.ci-ort-scan ([dcff847](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/dcff84783ec9d6de9c11d52e0e7c67627ee3fee0))
* **release:** 1.9.0 ([31c45d2](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/31c45d22b6ff815c87c500cf6ffae0e5baee83a7))

## [1.9.0](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/compare/1.8.2...1.9.0) (2023-10-25)


### 🦊 CI/CD

* enabled push to harbor ([2f23b3c](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/2f23b3c0a9d66306fb8fe5323feab4655726b4c0))


### 🚀 Features

* **java17:** cleanup ([8e51e8a](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/8e51e8aecdf17d08c72c7cff6bd9738f1c99809b))
* **java17:** migrate to java17 and update related dependencies ([2399a0d](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/2399a0dd33a1cb032befdb5ecc7edf782a31442e))
* **java17:** switch to 17-jre-centos7 ([8f884df](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/8f884df5081bb074d61af72193116b52a8e0bf51))
* **java17:** switch to openjdk:17-ea-jdk-oracle ([2e63559](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/2e6355913797b0d8d9ab4d9aa7426eed6f8cd741))


### Other

* **release:** 1.8.2 ([6f1f853](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/6f1f853320361058f4c24cd3468180b51673e06d))

## [1.8.2](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/compare/1.8.1...1.8.2) (2023-10-09)


### 🛠 Fixes

* **doc:** updated readme ([233cfa5](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/233cfa5395fa1c807be5a6f62394a00c99ff2fdb))


### Other

* fix version ([1ef9f62](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/1ef9f621e285bdb34d748ca595189dc00d68d8c0))
* **doc:** minor update in readme (testing pipeline) ([7bafd2e](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/7bafd2e4bbc275ff815db8f812ec38d0105bd8f7))
* **doc:** minor update in readme (testing pipeline) ([70787de](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/70787de81e500e5a5aeb8b338979b296677c37bd))
* **release:** 1.8.1 ([0c71f65](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/0c71f657be348bc89a405a1a6017762bb707300e))

## [1.8.1](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/compare/1.8.0...1.8.1) (2023-10-02)


### 💈 Style

* add .gitattributes for line endings ([e6a5f4a](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/e6a5f4aecbabe79172b4ca70ec800bb0bb548930))
* add spotless plugin for code formatting ([b9d9ee4](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/b9d9ee454618ace6689dd8afe1884c1c22f00fea))
* fix line endings ([7202310](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/7202310bbe31a9bb9ff47365da1464c77c554013))


### 🛠 Fixes

* removed mtr_to_harbor from gitlab-ci as its already included in the pipeline ([3166028](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/3166028a99f0d6599de0aab3c7e534815dc965ec))
* **deps:** changed pipeline to java-maven-docker-release-pipeline ([649cb5a](https://gitlab.devops.telekom.de/dhei/teams/hyperion/dev/src/issuer-service/commit/649cb5ad8af6105da59abd57d6553f5d52666190))
