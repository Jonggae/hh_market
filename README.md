
## AWS 서버
퍼블릭 IP : 3.34.185.148

PostMan 으로 [http://3.34.185.148/api/items] Get요청 시 데이터 조회 가능

데이터 수정, 삭제, 상세조회도 가능함.


## 요구사항

- 게시글 목록 DB
    - 테이블명 : Item
        - id : 게시글 번호 (DB 인덱스)
        - title (String) :  게시글 제목
        - content (String) : 게시글 내용
        - price(int) : 가격
        - username : 작성자
- APi 예시
![image](https://github.com/Jonggae/hh_market/assets/130136857/24a9625d-317f-498f-b43f-41ba047e01a7)
