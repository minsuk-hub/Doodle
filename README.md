이 프로젝트는 많은 시간이 지난 후 더 이상 유지보수되지 않았으며, 코드 설계의 문제로 많은 기능이 확장하기 어렵습니다. 따라서 이는 학습 및 참고용으로만 사용되어야 합니다. 모두에게 이 프로젝트의 원리를 이해한 후에 자신의 Doodle 라이브러리를 구축하는 것을 권장합니다.

자신의 Doodle 라이브러리를 만들려는 경우 몇 가지 제안이 있습니다. 이를 통해 많은 작업을 절약할 수 있습니다:

비트맵을 캔버스로 사용하세요. 이것은 지우개 기능을 구현하기에 용이한데, (현재 doodle 라이브러리는 이를 고려하지 않아 투명 이미지를 지울 때 문제가 발생합니다) 또한 더 복잡한 기능을 위한 기반을 마련하기 위함입니다.
모든 변환 작업에 Matrix 객체를 사용하세요. 다시 계산 공식을 직접 작성하는 것은 무지한 일입니다. (현재 doodle는 이렇게 직접 계산하고 있습니다...)
데이터 직렬화 및 저장에는 Gson을 사용하세요. (현재 doodle 라이브러리에는 이 부분이 포함되어 있지 않으며, 그 디자인으로 인해 데이터 저장을 추가하려면 매우 어려울 것입니다...)
위 내용은 참고용이며, 여러분의 프로젝트에 도움이 될 수 있습니다.

앞으로 시간이 되면 더욱 포괄적이고 새로운 Doodle 라이브러리를 개발하고 기여할 수 있으면 좋겠습니다! 여러분의 지원에 감사드립니다! 만약 도움이 필요하거나 조언이 필요하시다면 언제든지 연락해주세요. 성공을 기원합니다!

# Doodle

[![](https://jitpack.io/v/1993hzw/Doodle.svg)](https://jitpack.io/#1993hzw/Doodle)

Doodle은 안드로이드 이미지 그리기 앱으로, 되돌리기, 확대/축소, 이동, 텍스트 추가, 스티커 추가 등의 기능을 갖추고 있습니다. 강력하고 사용자 정의 및 확장 가능한 그림판 프레임워크이자 다기능 그림판입니다.



![01.gif](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/01.gif)

![01](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/01.png)
![02](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/02.png)
![03](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/03_2.png)

# Feature 기능

  * ***브러쉬 및 모양***

    *브러쉬는 손그림, 모자이크, 복제, 지우개, 텍스트, 스티커를 선택할 수 있습니다. 복제 기능은 PS의 것과 유사하며 이미지의 특정 부분을 복사합니다. 모양은 손그림, 화살표, 직선, 원, 사각형 등을 선택할 수 있습니다. 브러쉬의 배경색은 색상이나 이미지를 선택할 수 있습니다.*

  *  ***취소/되돌리기***
    
     *모든 그림 작업 단계를 취소 및 되돌릴 수 있습니다。*

  * ***확대/축소, 이동 및 회전***

    *그리기 과정 중에 이미지를 제스처로 자유롭게 축소, 이동, 회전할 수 있습니다. 그림을 이동, 회전, 축소할 수 있습니다.*

  * ***확대 및 축소 도구***

    *그림을 더 디테일하게 그리기 위해, 그림 그리기 중에 확대기를 사용할 수 있습니다.*


# 사용 방법

#### Build.Gradle 

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
 
dependencies {
    compile 'com.github.1993hzw:Doodle:5.5.3'
}
```

***Doodle 라이브러리를 사용하는 방법에는 두가지가 있습니다.***

### ***A. 이미 작성된 그림 그리기 인터페이스를 사용하여 직접 시작합니다. 시작 페이지는 위의 데모 이미지를 참조하십시오. 더 많은 사용자 정의 상호작용 방식이 필요한 경우, 다른 방법(B 방법)을 사용하세요.***
```java
DoodleParams params = new DoodleParams(); // 그림 그리기 매개변수
params.mImagePath = imagePath; // 이미지 파일의 경로
DoodleActivity.startActivityForResult(MainActivity.this, params, REQ_CODE_DOODLE);
```
*[DoodleParams](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleParams.java) 더 많은 그림 그리기 매개변수 정보를 얻으려면 다음과 같은 항목들을 참고하세요*

###  B. ***추천하는 방법은 DoodleView를 사용하는 것입니다. 이는 확장성이 뛰어나며, 유연하며, 자체적으로 상호작용 인터페이스를 사용자 정의하기 쉬운 클래스입니다. DoodleView를 사용하여 자신만의 그림 그리기 앱을 만들 수 있으며, 이를 통해 그림 그리기 기능을 더욱 효과적으로 구현하고 사용자에게 더 좋은 경험을 제공할 수 있습니다.***

```java
/*
그림 그리기 최적화를 추천합니다. 이를 통해 그림 그리기 속도와 성능을 최적화할 수 있습니다.

그러나 주의할 점은, 최적화를 켜면 아이템이 선택되어 편집 중일 때 해당 아이템이 최상위 레이어에 그려지며, 편집이 끝날 때까지 해당 레이어에 그려지지 않습니다. 이 부분에 주의하여 구현해야 합니다.
 */
boolean optimizeDrawing = true;
DoodleView mDoodleView = new DoodleView(this, bitmap, optimizeDrawing, new IDoodleListener() {
            /*
            낙서한 이미지를 저장할 때 호출됩니다.
             */
            @Override
            public void onSaved(IDoodle doodle, Bitmap bitmap, Runnable callback) {
               // 실행할 코드
            }

            /*
             뷰의 측정이 완료되어 이제 그리기 준비가 완료되었습니다. 이 시점에서 크기, 색상, 펜, 모양 등을 설정할 수 있습니다.
             */
            @Override
            public void onReady(IDoodle doodle) {
                // 실행할 코드
            }
        });

mTouchGestureListener = new DoodleOnTouchGestureListener(mDoodleView, new DoodleOnTouchGestureListener.ISelectionListener() {
    /*
     아이템(예: 텍스트, 텍스처)이 선택되거나 선택 해제될 때 호출됩니다.
     */
    @Override
    public void onSelectedItem(IDoodle doodle, IDoodleSelectableItem selectableItem, boolean selected) {
        // 실행할 코드
    }

    /*
     뷰를 클릭하여 아이템(예: 텍스트, 텍스처)을 생성할 때 호출됩니다.
     */
    @Override
    public void onCreateSelectableItem(IDoodle doodle, float x, float y) {
        // 실행할 코드
        /*
if (mDoodleView.getPen() == DoodlePen.TEXT) {
        IDoodleSelectableItem item = new DoodleText(mDoodleView, "hello", 20 * mDoodleView.getUnitSize(), new DoodleColor(Color.RED), x, y);
        mDoodleView.addItem(item);
} else if (mDoodleView.getPen() == DoodlePen.BITMAP) {
        IDoodleSelectableItem item = new DoodleBitmap(mDoodleView, bitmap, 80 * mDoodle.getUnitSize(), x, y);
        mDoodleView.addItem(item);
}
        */
    }
});

// 터치 감지기를 생성하여 스크롤, 확대/축소, 단일 탭 등의 제스처를 감지합니다.
IDoodleTouchDetector detector = new DoodleTouchDetector(getApplicationContext(), mTouchGestureListener);
mDoodleView.setDefaultTouchDetector(detector);

// 파라미터 설정
mDoodleView.setPen(DoodlePen.TEXT);
mDoodleView.setShape(DoodleShape.HAND_WRITE);
mDoodleView.setColor(new DoodleColor(Color.RED));


```
최적화된 드로잉을 끌 때, 아이템을 생성할 때 `addItem(IDoodleItem)`만 호출하면 됩니다. 드로잉 최적화를 시작할 때는 생성된 아이템이나 선택된 아이템에 대해 `markItemToOptimizeDrawing(IDoodleItem)`을 호출해야 하며, 드로잉이 끝나면 `notifyItemFinishedDrawing(IDoodleItem)`을 호출해야 합니다. 그래서 일반적으로 코드에서 이렇게 사용됩니다:

```java
// 아이템을 생성하거나 아이템을 선택하여 편집할 때
if (mDoodle.isOptimizeDrawing()) {
   mDoodle.markItemToOptimizeDrawing(item);
} else {
   mDoodle.addItem(item);
}

...

// 생성 또는 편집 완료
if (mDoodle.isOptimizeDrawing()) {
   mDoodle.notifyItemFinishedDrawing(item);
}
```


그런 다음 DoodleView를 레이아웃에 추가하세요. 이제 자유롭게 그림을 그릴 수 있습니다.

# 데모

다음은 두들 프레임워크를 사용하는 방법을 가르쳐 줄 간단한 예제들입니다.

1. **[모자이크 효과](https://github.com/1993hzw/Doodle/blob/master/app/src/main/java/cn/hzw/doodledemo/MosaicDemo.java)**

2. **[확대 및 축소 제스쳐로 텍스트 크기 변경](https://github.com/1993hzw/Doodle/blob/master/app/src/main/java/cn/hzw/doodledemo/ScaleGestureItemDemo.java)**

이어서...

이제 DoodleActivity에서 DoodleView를 사용하고 있다는 것을 알게 되셨을 겁니다. DoodleActivity처럼 사용자 정의 레이아웃을 구성할 수도 있습니다. 자세한 내용은 [DoodleActivity](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleActivity.java)를 참고하세요.

***DoodleView는 IDoodle 인터페이스를 구현하였습니다.***


```java
public interface IDoodle {
...
    public float getUnitSize();
    public void setDoodleRotation(int degree);
    public void setDoodleScale(float scale, float pivotX, float pivotY);
    public void setPen(IDoodlePen pen);
    public void setShape(IDoodleShape shape);
    public void setDoodleTranslation(float transX, float transY);
    public void setSize(float paintSize);
    public void setColor(IDoodleColor color);
    public void addItem(IDoodleItem doodleItem);
    public void removeItem(IDoodleItem doodleItem);
    public void save();
    public void topItem(IDoodleItem item);
    public void bottomItem(IDoodleItem item);
    public boolean undo(int step);
...
}
```
# 프레임워크 다이어그램

![구조](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/structure.png)

### Doodle 좌표
![좌표](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/doodle_coordinate.png)

# 확장

다음은 다양한 사용자 정의 항목을 생성하는 방법입니다:

- **[IDoodleItem](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleItem.java) 인터페이스를 구현하거나 [DoodleItemBase](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleItemBase.java)를 확장하여 [DoodlePath, DoodleText, DoodleBitmap](https://github.com/1993hzw/Doodle/tree/master/doodle/src/main/java/cn/hzw/doodle)와 같은 사용자 정의 두들 항목을 생성할 수 있습니다.**

- **[IDoodlePen](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodlePen.java) 인터페이스를 구현하여 DoodlePen과 같은 사용자 정의 펜을 생성할 수 있습니다.**

- **[IDoodleShape](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleShape.java) 인터페이스를 구현하여 DoodleShape와 같은 사용자 정의 형상을 생성할 수 있습니다.**

- **[IDoodleColor](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleColor.java) 인터페이스를 구현하여 DoodleColor와 같은 사용자 정의 색상을 생성할 수 있습니다.**

- **[IDoodleTouchDetector](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleTouchDetector.java) 인터페이스를 구현하여 [DoodleTouchDetector](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleTouchDetector.java)([GestureListener](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleOnTouchGestureListener.java))와 같은 사용자 정의 터치 제스처 감지기를 생성할 수 있습니다.**

***[Others](https://github.com/1993hzw/Doodle/blob/master/extend.md)***

# 개발자

hzw19933@gmail.com

154330138@qq.com

Q&A <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=d225a990b29a135d4a601be7a198f04572f1dbd96ccd5be944ff2ef87dda5c11"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="Doodle-涂鸦交流群" title="Doodle-涂鸦交流群"></a>  6762102


***[내 블로그를 방문해주셔서 감사합니다. Doodle에 관한 더 많은 글을 읽어보세요!](https://blog.csdn.net/u012964944)***

[《안드로이드 그림판 기본 원리 설명 - 초급부터 고급까지（一）》](https://blog.csdn.net/u012964944/article/details/82703684)

[《안드로이드 그림판 기본 원리 설명 - 초급부터 고급까지（二）》](https://blog.csdn.net/u012964944/article/details/83420038)

[《그림판 프레임워크 최적화 - 그리기 중의 버벅임 문제 해결, 부드러운 그림 그리기》](https://blog.csdn.net/u012964944/article/details/89211683)

# License

  ```
  MIT License
  
  Copyright (c) 2018 huangziwei
  
  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:
  
  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.
  
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
  ```
