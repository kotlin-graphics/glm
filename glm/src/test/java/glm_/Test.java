package glm_;

import glm_.mat4x4.Mat4;
import glm_.vec1.Vec1;
import glm_.vec2.Vec2;
import glm_.vec2.Vec2us;
import glm_.vec3.Vec3;

import static glm_.Java.glm;

//import static glm_.glm;

/**
 * Created by GBarbieri on 08.02.2017.
 */
public class Test {

//    final static Glm glm = Glm.INSTANCE;

    public static void main(String[] argvs) {
        glm.normalize(3.4);
        glm.detail.mod289(new Vec2(3.0));
        glm_.glm.detail.mod289(new Vec2());

        Vec2 v = new Vec2(3, 4);

        Vec2 a = (Vec2) v.xx();
        a.getX();
        a.xy(v.xy());
        Vec1 b = new Vec1();
        int l = Vec1.length;
//        Vec2 b = (Vec2) v.aa();

        Vec2 c = Vec2.fromPointer(4L);

        Vec1 d = new Vec1();
        Vec1 e = new Vec1(d);
//        Vec2us f = new Vec2us((Short)3);
    }


    public Mat4 transform(Vec2 orientation, Vec3 translate, Vec3 up) {
        Mat4 proj = glm.perspective(glm.radians(45f), 1.33f, 0.1f, 10f);
        Mat4 viewTranslate = glm.translate(new Mat4(1f), translate);
        Mat4 viewRotateX = glm.rotate(viewTranslate, orientation.getY(), up);
        Mat4 view = glm.rotate(viewRotateX, orientation.getX(), up);
        Mat4 model = new Mat4(1f);
        return proj.times(view).times(model);
    }
}
