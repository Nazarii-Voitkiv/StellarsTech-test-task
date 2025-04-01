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



public class p01 extends JFrame implements GLEventListener {

	private GL2 gl;
	
	public p01(String string) {
		super(string);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		setBounds(d.width/4, d.height/4, d.width/2, d.height/2);
		GLProfile profile=GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities=new GLCapabilities(profile);
		GLCanvas canvas=new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		add(canvas);
		setVisible(true);
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		
		
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glColor3f(1.0f, 0.0f, 0.0f); gl.glVertex3f(-1.0f, -1.0f, 0.0f);
		gl.glColor3f(0.0f, 1.0f, 0.0f); gl.glVertex3f( 1.0f, -1.0f, 0.0f);
		gl.glColor3f(0.0f, 0.0f, 1.0f);gl.glVertex3f( 0.0f,  1.0f, 0.0f);
		gl.glEnd();
		
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl=drawable.getGL().getGL2();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new p01("p01");
			}
		});
	}

}
