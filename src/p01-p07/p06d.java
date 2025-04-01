import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

public class p06d extends JFrame implements GLEventListener {

	private GL2 gl;
	private GLU glu;
	private GLUT glut;
	private FPSAnimator animator;
	private float kat = 0.0f;

	public p06d(String string) {
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
		//animator.start();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glRotatef(kat, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(kat, 0.0f, 0.0f, 1.0f);
		int n = 16;
		double r = 1.0;
		
		gl.glPushMatrix();
		gl.glColor3f(1.0f, 1.0f, 0.0f);
		gl.glScalef(1.0f, 1.5f, 1.0f);
		Polkula.Draw(gl, r, n*3, n*3/2);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glColor3f(1.0f, 1.0f, 0.0f);
		gl.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
		Polkula.Draw(gl, r, n*3, n);
		gl.glPopMatrix();
		
		gl.glFlush();
		kat += 1.0f;
		if (kat >= 360.0f)
			kat -= 360.0f;
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

		gl.glEnable(GL2.GL_CULL_FACE);
		float matSpec[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, matSpec, 0);
		gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 128);

		gl.glEnable(GL2.GL_COLOR_MATERIAL);
		gl.glColorMaterial(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE);

		float ambientLight[] = { 0.1f, 0.1f, 0.1f, 1.0f };
		gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, ambientLight, 0);

		gl.glEnable(GL2.GL_LIGHTING);

		float ambient[] = { 0.1f, 0.1f, 0.1f, 1.0f };
		float diffuse[] = { 0.5f, 0.5f, 0.5f, 1.0f };
		float specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float position[] = { -3.0f, 3.0f, 5.0f, 1.0f };
		
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position, 0);

		gl.glEnable(GL2.GL_LIGHT0);
		gl.glEnable(GL2.GL_NORMALIZE);
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
		glu.gluPerspective(45.0, aspect, 1.0, 10.0);
		glu.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new p06d("p06d");
			}
		});
	}

}
