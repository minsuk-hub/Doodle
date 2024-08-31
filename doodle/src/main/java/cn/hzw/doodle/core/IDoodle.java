package cn.hzw.doodle.core;

import android.graphics.Bitmap;

import java.util.List;

/**
 * 27/06/2018 생성.
 */

public interface IDoodle {
    /**
     * 현재 Doodle 좌표계에서 단위 크기를 가져옵니다. 이는 이미지와는 무관하게 dp를 기준으로 합니다.
     *
     * @return
     */
    public float getUnitSize();

    /**
     * 이미지 회전 값을 설정합니다.
     *
     * @param degree
     */
    public void setDoodleRotation(int degree);

    /**
     * 이미지 회전 값을 가져옵니다.
     *
     * @return
     */
    public int getDoodleRotation();

    /**
     * 이미지 축소/확대 배율을 설정합니다.
     *
     * @param scale
     * @param pivotX
     * @param pivotY
     */
    public void setDoodleScale(float scale, float pivotX, float pivotY);

    /**
     * 이미지 축소/확대 배율 값을 가져옵니다.
     */
    public float getDoodleScale();

    /**
     * 펜의 값을 설정합니다.
     *
     * @param pen
     */
    public void setPen(IDoodlePen pen);

    /**
     * 펜의 값을 가져옵니다.
     */
    public IDoodlePen getPen();

    /**
     * 도형의 값을 설정합니다.
     *
     * @param shape
     */
    public void setShape(IDoodleShape shape);

    /**
     * 도형의 값을 가져옵니다.
     */
    public IDoodleShape getShape();

    /**
     * 이미지의 x 방향 오프셋과 y오프셋을 동시에 설정합니다.
     *
     * @param transX
     */
    public void setDoodleTranslation(float transX, float transY);


    /**
     * 이미지의 x 방향 오프셋을 설정합니다.
     *
     * @param transX
     */
    public void setDoodleTranslationX(float transX);

    /**
     * 이미지의 x 방향 오프셋을 가져옵니다.
     *
     * @return
     */
    public float getDoodleTranslationX();

    /**
     * 이미지의 y 방향 오프셋을 설정합니다.
     *
     * @param transY
     */
    public void setDoodleTranslationY(float transY);

    /**
     * 이미지의 y 방향 오프셋을 가져옵니다.
     *
     * @return
     */
    public float getDoodleTranslationY();

    /**
     * 크기를 설정합니다.
     *
     * @param paintSize
     */
    public void setSize(float paintSize);

    /**
     * 크기를 가져옵니다.
     *
     * @return
     */
    public float getSize();

    /**
     * 색상을 설정합니다.
     *
     * @param color
     */
    public void setColor(IDoodleColor color);

    /**
     * 색상을 가져옵니다.
     *
     * @return
     */
    public IDoodleColor getColor();

    /**
     * 최소 축소 및 확대 배율을 제한합니다.
     *
     * @param minScale
     */
    public void setDoodleMinScale(float minScale);

    /**
     * 최소 축소 및 확대 배율을 가져옵니다.
     *
     * @return
     */
    public float getDoodleMinScale();

    /**
     * 최대 축소 및 확대 배율을 제한합니다.
     *
     * @param maxScale
     */
    public void setDoodleMaxScale(float maxScale);

    /**
     * 최대 축소 및 확대 배율을 가져옵니다.
     *
     * @return
     */
    public float getDoodleMaxScale();

    /**
     * item을 추가합니다.
     *
     * @param doodleItem
     */
    public void addItem(IDoodleItem doodleItem);

    /**
     * item을 삭제합니다.
     *
     * @param doodleItem
     */
    public void removeItem(IDoodleItem doodleItem);

    /**
     * 전체 아이템의 갯수
     * exclude redo items
     *
     * @return
     */
    public int getItemCount();

    /**
     * 获取所有的涂鸦(不包括重做)
     *  exclude redo items
     * @return
     */
    public List<IDoodleItem> getAllItem();

    /**
     * total redo item count
     *
     * @return
     */
    public int getRedoItemCount();

    /**
     * 获取所有重做的涂鸦
     *
     * @return
     */
    public List<IDoodleItem> getAllRedoItem();

    /**
     * 设置放大镜倍数
     *
     * @param scale
     */
    public void setZoomerScale(float scale);

    /**
     * 获取放大镜倍数
     *
     * @return
     */
    public float getZoomerScale();


    /**
     * 是否允许涂鸦显示在图片边界之外
     *
     * @param isDrawableOutside
     */
    public void setIsDrawableOutside(boolean isDrawableOutside);

    /**
     * 是否允许涂鸦显示在图片边界之外
     */
    public boolean isDrawableOutside();

    /**
     * 是否显示原图
     *
     * @param justDrawOriginal
     */
    public void setShowOriginal(boolean justDrawOriginal);

    /**
     * 是否显示原图
     */
    public boolean isShowOriginal();

    /**
     * 保存当前涂鸦图片
     */
    public void save();

    /**
     * 清楚所有涂鸦
     */
    public void clear();

    /**
     * 置顶item
     *
     * @param item
     */
    public void topItem(IDoodleItem item);

    /**
     * 置底item
     *
     * @param item
     */
    public void bottomItem(IDoodleItem item);

    /**
     * 撤销一步
     *
     * @return
     */
    public boolean undo();

    /**
     * 指定撤销的步数
     *
     * @param step
     * @return
     */
    public boolean undo(int step);

    /**
     * 指定重做的步数
     *
     * @param step
     * @return
     */
    public boolean redo(int step);

    /**
     * 获取当前显示的图片(无涂鸦)
     *
     * @return
     */
    public Bitmap getBitmap();

    /**
     * 获取当前显示的图片(包含涂鸦)
     *
     * @return
     */
    public Bitmap getDoodleBitmap();

    /**
     * 刷新
     */
    public void refresh();

}
