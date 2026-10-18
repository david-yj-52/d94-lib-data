Provider는 Reader혹은 Writer의 Jpa Component를 가지고 있음

Jpa Component 구분은 Reader와 Wirter로 구분

Jpa Component 생성 기준

1. 메소드 5개 이상

Reader와 Writer 구분 기준 메소드 10개 이상

캐싱 필요 시, implementation 'org.springframework.boot:spring-boot-starter-cache' implementation
'com.github.ben-manes.caffeine:caffeine' // 로컬 캐시 구현체 추천