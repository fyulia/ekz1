//package bricks;

import java.awt.Image;
import java.awt.Rectangle;

class HardBrick extends Brick {
    /*
     * @_hitCount - количество допустимых ударов шайбой
     *            кирпич разрушается, как только атрибут
     * 			  будет равен нулю
     * @_woundImg - изображение поврежденого кирпича
     * 			  заменяет исходное изображение при первом
     * 			  ударе шайбы
     */

    private int _hitCount = 2;
    private Image _woundImg;
    protected BrickPile _bp1;


    public HardBrick(PlayField pf, BrickPile bp, Rectangle p, Image img, Image woundImg) {
        super(pf, bp, img,  p);
        _woundImg = woundImg;
        _bp1= bp;
    }

    /* Oбработка соударения с шайбой. Как только
     * значение _hitCount становится равным нулю
     * и будет удален с игрового поля
     */

    public void hitBy(Puck p) {
        if (_hitCount > 1) {
            _img = _woundImg;
            _hitCount--;
        } else {
            _isDead = true;
            if (_bp1.unbrokenCount() == 1) {
                _pf.getMatch().win();
            }
        }

        p.getVelocity().reverseY();
    }
}
