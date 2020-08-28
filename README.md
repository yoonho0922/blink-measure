## 눈 깜빡임 측정 앱
![result.gif](https://github.com/yoonho0922/blink-measure/blob/master/public/result.gif?raw=true)

* 정면의 얼굴의 눈 영역을 실시간으로 검출

* 눈의 가로세로 비율(EAR)을 실시간 그래프로 표시

* 1분 동안 측정 후 분당 눈 깜빡임 수와 속도를 검출

#### 한계

* 정확도 문제
  * 움직임, 카메라 각도에 의한 측정 오류가 있음

* 실용성의 부족

  * 백그라운드에서 측정을 할 수 없음
  * 스마트폰을 세로로 해야만 측정할 수 있음
  * 실용성을 위한 기능을 구현하지 못 함 (기록, 통계 등)

#### 사용 라이브러리

* [ML kit Vision APIs](https://developers.google.com/ml-kit)  

* [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) 

#### 기간

* 2020.08.17 ~ 2020.08.27
