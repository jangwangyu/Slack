#요구사항

관심가상화폐의 실시간 가격을 조회하여 슬랙으로 알림 메시지를 발송할 수 있다.
발송한 내역을 데이터베이스에 저장할 수 있다.

업비트에서 데이터를 조회할 수 있다. => restTemplate, feignClient

조회한 데이터는 슬랙으로 메시지를 전송한다. => slack api, webhook

해당 기능은 정기적으로 수행되어야 한다. => github action, springBatch

인메모리 데이터 베이스는 사용할 수 없다. => mysql 활용
데이터베이스 조회 시에는 jpa와 querydsl을 활용한다.