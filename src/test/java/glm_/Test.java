package glm_;

import glm_.Java.Glm;
import glm_.quat.Quat;
import glm_.vec2.Vec2;

//import static glm.Java.glm;

/**
 * Created by GBarbieri on 08.02.2017.
 */
public class Test {

    final static Glm glm = Glm.INSTANCE;

    public static void main(String[] argvs) {
        glm.normalize(3.4);
        Glm.detail.mod289(new Vec2());

        Vec2 v = new Vec2(3, 4);

        float f = v.x;

        Quat quat = new Quat();

        v.x = 3f;
        float x = v.x;
    }
}
