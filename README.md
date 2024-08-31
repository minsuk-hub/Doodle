이 프로젝트는 많은 시간이 지난 후 더 이상 유지보수되지 않았으며, 코드 설계의 문제로 많은 기능이 확장하기 어렵습니다. 따라서 이는 학습 및 참고용으로만 사용되어야 합니다. 모두에게 이 프로젝트의 원리를 이해한 후에 자신의 Doodle 라이브러리를 구축하는 것을 권장합니다.

자신의 Doodle 라이브러리를 만들려는 경우 몇 가지 제안이 있습니다. 이를 통해 많은 작업을 절약할 수 있습니다:

비트맵을 캔버스로 사용하세요. 이것은 지우개 기능을 구현하기에 용이한데, (현재 doodle 라이브러리는 이를 고려하지 않아 투명 이미지를 지울 때 문제가 발생합니다) 또한 더 복잡한 기능을 위한 기반을 마련하기 위함입니다.
모든 변환 작업에 Matrix 객체를 사용하세요. 다시 계산 공식을 직접 작성하는 것은 무지한 일입니다. (현재 doodle는 이렇게 직접 계산하고 있습니다...)
데이터 직렬화 및 저장에는 Gson을 사용하세요. (현재 doodle 라이브러리에는 이 부분이 포함되어 있지 않으며, 그 디자인으로 인해 데이터 저장을 추가하려면 매우 어려울 것입니다...)
위 내용은 참고용이며, 여러분의 프로젝트에 도움이 될 수 있습니다.

앞으로 시간이 되면 더욱 포괄적이고 새로운 Doodle 라이브러리를 개발하고 기여할 수 있으면 좋겠습니다! 여러분의 지원에 감사드립니다! 만약 도움이 필요하거나 조언이 필요하시다면 언제든지 연락해주세요. 성공을 기원합니다!

# Doodle

[![](https://jitpack.io/v/1993hzw/Doodle.svg)](https://jitpack.io/#1993hzw/Doodle)

Image doodle for Android. You can undo, zoom, move, add text, textures, etc. Also, a powerful, customizable and extensible doodle framework & multi-function drawing board.


안드로이드 이미지 그리기 앱으로, 되돌리기, 확대/축소, 이동, 텍스트 추가, 스티커 추가 등의 기능을 갖추고 있습니다. 강력하고 사용자 정의 및 확장 가능한 그림판 프레임워크이자 다기능 그림판입니다.



![01.gif](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/01.gif)

![01](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/01.png)
![02](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/02.png)
![03](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/03_2.png)

# Feature 기능

  * ***브러쉬 및 모양***

    ***브러쉬는 손그림, 모자이크, 복제, 지우개, 텍스트, 스티커를 선택할 수 있습니다. 복제 기능은 PS의 것과 유사하며 이미지의 특정 부분을 복사합니다. 모양은 손그림, 화살표, 직선, 원, 사각형 등을 선택할 수 있습니다. 브러쉬의 배경색은 색상이나 이미지를 선택할 수 있습니다.***

    ***취소/되돌리기***
    
    ***모든 그림 작업 단계를 취소 및 되돌릴 수 있습니다。***

  * ***확대/축소, 이동 및 회전***

    In the process of doodle, you can freely zoom, move and rotate the picture with gestures. Also, you can move，rotate and scale the doodle item.
    
    ***그리기 과정 중에 이미지를 제스처로 자유롭게 축소, 이동, 회전할 수 있습니다. 그림을 이동, 회전, 축소할 수 있습니다.***

  * ***확대 및 축소 도구***

    In order to doodle more finely, an zoomer can be set up during the doodle process.
    
    ***그림을 더 디테일하게 그리기 위해, 그림 그리기 중에 확대기를 사용할 수 있습니다.***

# Usage 用法

#### Gradle 

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

### ***A. 이미 작성된 그림 그리기 인터페이스를 사용하여 직접 시작합니다. 시작 페이지는 위의 데모 이미지를 참조하십시오. 더 많은 사용자 정의 상호작용 방식이 필요한 경우, 다른 방법(B 방법)을 사용하십시오.***
```java
DoodleParams params = new DoodleParams(); // 그림 그리기 매개변수
params.mImagePath = imagePath; // the file path of image
DoodleActivity.startActivityForResult(MainActivity.this, params, REQ_CODE_DOODLE);
```
See [DoodleParams](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleParams.java) for more details.

***[DoodleParams](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleParams.java) 더 많은 그림 그리기 매개변수 정보를 얻으려면 다음과 같은 항목들을 참고하세요:。***

###  B. ***추천하는 방법은 DoodleView를 사용하는 것입니다. 이는 확장성이 뛰어나며, 유연하며, 자체적으로 상호작용 인터페이스를 사용자 정의하기 쉬운 클래스입니다. DoodleView를 사용하여 자신만의 그림 그리기 앱을 만들 수 있으며, 이를 통해 그림 그리기 기능을 더욱 효과적으로 구현하고 사용자에게 더 좋은 경험을 제공할 수 있습니다.***

```java
/*
Whether or not to optimize drawing, it is suggested to open, which can optimize the drawing speed and performance.
Note: When item is selected for editing after opening, it will be drawn at the top level, and not at the corresponding level until editing is completed.

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
               //do something
            }

            /*
             called when it is ready to doodle because the view has been measured. Now, you can set size, color, pen, shape, etc. 
             此时view已经测量完成，涂鸦前的准备工作已经完成，在这里可以设置大小、颜色、画笔、形状等。
             */
            @Override
            public void onReady(IDoodle doodle) {
                //do something
            }
        });

mTouchGestureListener = new DoodleOnTouchGestureListener(mDoodleView, new DoodleOnTouchGestureListener.ISelectionListener() {
    /*
     called when the item(such as text, texture) is selected/unselected.
     item（如文字，贴图）被选中或取消选中时回调
     */
    @Override
    public void onSelectedItem(IDoodle doodle, IDoodleSelectableItem selectableItem, boolean selected) {
        //do something
    }

    /*
     called when you click the view to create a item(such as text, texture).
     点击View中的某个点创建可选择的item（如文字，贴图）时回调
     */
    @Override
    public void onCreateSelectableItem(IDoodle doodle, float x, float y) {
        //do something
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

// create touch detector, which dectects the gesture of scoll, scale, single tap, etc.
// 创建手势识别器，识别滚动，缩放，点击等手势
IDoodleTouchDetector detector = new DoodleTouchDetector(getApplicationContext(), mTouchGestureListener);
mDoodleView.setDefaultTouchDetector(detector);

// Setting parameters.设置参数
mDoodleView.setPen(DoodlePen.TEXT);
mDoodleView.setShape(DoodleShape.HAND_WRITE);
mDoodleView.setColor(new DoodleColor(Color.RED));


```
When turning off optimized drawing, you only need to call `addItem(IDoodleItem)` when you create it. When you start optimizing drawing, the created or selected item needs to call `markItemToOptimizeDrawing(IDoodleItem)`, and you should call `notifyItemFinishedDrawing(IDoodleItem)` when you finish drawing. So this is generally used in code:

***当关闭优化绘制时,只需要在创建时调用`addItem(IDoodleItem)`;而当开启优化绘制时，创建或选中的item需要调用`markItemToOptimizeDrawing(IDoodleItem)`,结束绘制时应调用`notifyItemFinishedDrawing(IDoodleItem)`。因此在代码中一般这样使用：***
```java
// when you are creating a item or selecting a item to edit
if (mDoodle.isOptimizeDrawing()) {
   mDoodle.markItemToOptimizeDrawing(item);
} else {
   mDoodle.addItem(item);
}

...

// finish creating or editting
if (mDoodle.isOptimizeDrawing()) {
   mDoodle.notifyItemFinishedDrawing(item);
}
```


Then, add the DoodleView to your layout. Now you can start doodling freely.

 ***把DoodleView添加到布局中，然后开始涂鸦。***

# Demo 实例

Here are other simple examples to teach you how to use the doodle framework.

1. **[Mosaic effect](https://github.com/1993hzw/Doodle/blob/master/app/src/main/java/cn/hzw/doodledemo/MosaicDemo.java)**
 ***[马赛克效果](https://github.com/1993hzw/Doodle/blob/master/app/src/main/java/cn/hzw/doodledemo/MosaicDemo.java)***

2. **[Change text's size by scale gesture](https://github.com/1993hzw/Doodle/blob/master/app/src/main/java/cn/hzw/doodledemo/ScaleGestureItemDemo.java)**
 ***[手势缩放文本大小](https://github.com/1993hzw/Doodle/blob/master/app/src/main/java/cn/hzw/doodledemo/ScaleGestureItemDemo.java)***

More...

Now I think you should know that DoodleActivity has used DoodleView. You also can customize your layout like DoodleActivity. See [DoodleActivity](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleActivity.java) for more details.

***现在你应该知道DoodleActivity就是使用了DoodleView实现涂鸦，你可以参照[DoodleActivity](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleActivity.java)是怎么实现涂鸦界面的交互来实现自己的自定义页面。***

DoodleView has implemented IDoodle.

***DoodleView实现了IDoodle接口。***
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
# Framework diagram 框架图

![structure](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/structure.png)

### Doodle Coordinate 涂鸦坐标
![coordinate](https://raw.githubusercontent.com/1993hzw/common/master/Doodle/doodle_coordinate.png)

# Extend 拓展

You can create a customized item like [DoodlePath, DoodleText, DoodleBitmap](https://github.com/1993hzw/Doodle/tree/master/doodle/src/main/java/cn/hzw/doodle) which extend [DoodleItemBase](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleItemBase.java) or implement [IDoodleItem](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleItem.java). 

***实现[IDoodleItem](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleItem.java)接口或基础[DoodleItemBase](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleItemBase.java)，用于创建自定义涂鸦条目item，比如[DoodlePath, DoodleText, DoodleBitmap](https://github.com/1993hzw/Doodle/tree/master/doodle/src/main/java/cn/hzw/doodle)***

You can create a customized pen like DoodlePen which implements [IDoodlePen](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodlePen.java).

***实现[IDoodlePen](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodlePen.java)接口用于创建自定义画笔pen，比如DoodlePen***

You can create a customized shape like DoodleShape which implements [IDoodleShape](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleShape.java). 

***实现[IDoodleShape](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleShape.java)接口用于创建自定义形状shape，比如DoodleShape***

You can create a customized color like DoodleColor which implements [IDoodleColor](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleColor.java). 

***实现[IDoodleColor](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleColor.java)接口用于创建自定义颜色color，比如DoodleColor***

You can create a customized touch gesture detector like [DoodleTouchDetector](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleTouchDetector.java)([GestureListener](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/DoodleOnTouchGestureListener.java)) which implements [IDoodleTouchDetector](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleTouchDetector.java). 

***实现[IDoodleTouchDetector](https://github.com/1993hzw/Doodle/blob/master/doodle/src/main/java/cn/hzw/doodle/core/IDoodleTouchDetector.java)接口用于创建自定义手势识别器，比如DoodleTouchDetector***

***[Others](https://github.com/1993hzw/Doodle/blob/master/extend.md)***

# The developer 开发者

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
