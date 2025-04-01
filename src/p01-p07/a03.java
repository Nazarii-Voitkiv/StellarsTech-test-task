import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

public class a03 extends JFrame implements GLEventListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private float kat;
    private FPSAnimator animator;

    public a03(String string) {
        super(string);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        add(canvas);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        animator = new FPSAnimator(canvas, 60);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);

        int n = 8;
        float x = 0.5f;


        for (int i = 0; i < n; i++) {
            Prostopadloscian.Draw(gl, x * (2.0f * (n - i) - 1.0f), x * (2.0f * (n - i) - 1.0f), x,
                    2 * (n - i), 2 * (n - i), 2);
            gl.glTranslatef(0.0f, x, 0.0f);
        }

        gl.glFlush();

        kat += 1f;
        if (kat > 360.0f) {
            kat -= 360.0f;
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        glu = GLU.createGLU(gl);
        glut = new GLUT();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
        gl.glViewport(0, 0, width, height);
        if (height == 0)
            height = 1;
        float aspect = (float) width / height;
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, aspect, 1.0f, 30.0f);
        glu.gluLookAt(0.0f, 5.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new a03("a03");
            }
        });
    }

}