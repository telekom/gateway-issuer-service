# SPDX-FileCopyrightText: 2023 Deutsche Telekom AG
#
# SPDX-License-Identifier: Apache-2.0

FROM eclipse-temurin:17-jre-centos7

RUN groupadd --gid 1000 -r issuer-service && useradd --uid 1000 --no-log-init -r -g issuer-service issuer-service

USER 1000:1000

EXPOSE 8081 8081

COPY target/*.jar /usr/share/application.jar

WORKDIR /usr/share/

CMD ["java", "-jar", "/usr/share/application.jar"]

