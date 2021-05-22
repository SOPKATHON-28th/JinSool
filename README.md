## 서비스명: 진술게임
당신의 진솔적인 기억을 나눠보는 술자리 게임

## 역할 담당
### 강수현
1. QuestionFragment
  - 서버에서 Player API 호출 후 성공하면 질문 리스트에서 질문을
     하나씩 꺼내서 띄워줌
  - Timer를 이용하여 20초부터 시작해서 1초씩 감소하면서 초를 띄움
  - 버튼을 누르면 SelectFragment로 이동
2. SelectFragment
  - 다음 버튼 누르면 GameFragment로 이동
  - 벌칙 버튼 누르면 PenaltyFragment로 이동


### 김송현

Penaltyfragment : 서버에서 랜덤 값 받아오기 및 그에따른 이미지 출력
1. 벌칙 기능
- 서버 Penalty API 호출 후 성공 시 랜덤 값(0-2)에 따라 다른 벌칙 이미지 출력
- next_btn 클릭 시 -> rulletview 이동
- temp_btn 클릭 시 -> GameActivity 이동

2. 스플래시
- 어플 실행시 스플래시 3초 출력


### 이원중
1. 인원수 입력받고, Edittext 변화 감지 후 색 정하는 것 구현
2. 룰렛 뷰 구현
3. 앱 기초 셋팅

