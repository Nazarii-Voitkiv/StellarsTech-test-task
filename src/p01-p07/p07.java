
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

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
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class p07 extends JFrame implements GLEventListener {

	private GL2 gl;
	private GLU glu;
	private GLUT glut;
	private FPSAnimator animator;
	private float kat=0.0f;
	private int texture,texture1;
	
	public p07(String string) {
		super(string);
		GLProfile profile=GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities=new GLCapabilities(profile);
		GLCanvas canvas=new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		add(canvas);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		animator=new FPSAnimator(canvas,60);
		animator.start();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
		gl.glDisable(GL2.GL_DEPTH_TEST);
		gl.glDisable(GL2.GL_LIGHTING);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glPushMatrix();
		gl.glLoadIdentity();
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0.0f,0.0f); gl.glVertex3f(-1.0f,-1.0f,-1.0f);
		gl.glTexCoord2f(1.0f,0.0f); gl.glVertex3f( 1.0f,-1.0f,-1.0f);
		gl.glTexCoord2f(1.0f,1.0f); gl.glVertex3f( 1.0f, 1.0f,-1.0f);
		gl.glTexCoord2f(0.0f,1.0f); gl.glVertex3f(-1.0f, 1.0f,-1.0f);
		gl.glEnd();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glPopMatrix();
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glEnable(GL2.GL_LIGHTING);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		
		gl.glLoadIdentity();
		gl.glRotatef(kat, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(kat, 0.0f, 0.0f, 1.0f);
		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture1);
			
		for(int i=0;i<6;i++){
			gl.glBegin(GL2.GL_QUADS);
			gl.glNormal3f(0.0f, 0.0f, 1.0f);
			gl.glTexCoord2f(0.0f,0.0f); gl.glVertex3f(-1.0f,-1.0f,1.0f);
			gl.glTexCoord2f(1.0f,0.0f); gl.glVertex3f( 1.0f,-1.0f,1.0f);
			gl.glTexCoord2f(1.0f,1.0f); gl.glVertex3f( 1.0f, 1.0f,1.0f);
			gl.glTexCoord2f(0.0f,1.0f); gl.glVertex3f(-1.0f, 1.0f,1.0f);
			gl.glEnd();
			if(i%2==0) gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
			else gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
		}

		gl.glFlush();
		kat+=1.0f;
		if(kat>=360.0f)
			kat-=360.0f;
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl=drawable.getGL().getGL2();
		glu=GLU.createGLU(gl);
		glut=new GLUT();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		
		gl.glEnable(GL2.GL_CULL_FACE);
		float matSpec[]={1.0f,1.0f,1.0f,1.0f};
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, matSpec, 0);
		gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 128);
		
		gl.glEnable(GL2.GL_COLOR_MATERIAL);
		gl.glColorMaterial(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE);
		
		float ambientLight[]={0.1f,0.1f,0.1f,1.0f};
		gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, ambientLight, 0);
	
		gl.glEnable(GL2.GL_LIGHTING);
	
		float ambient[]={0.1f,0.1f,0.1f,1.0f};
		float diffuse[]={0.5f,0.5f,0.5f,1.0f};
		float specular[]={1.0f,1.0f,1.0f,1.0f};
		float position[]={-5.0f,5.0f,5.0f,1.0f};
		
		
		gl.glLightfv(GL2.GL_LIGHT0,GL2.GL_AMBIENT,ambient,0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse,0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular,0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position,0);
		
		gl.glEnable(GL2.GL_LIGHT0);
		//gl.glEnable(GL2.GL_NORMALIZE);
		
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		try{
			File f=new File("pic.jpg");
			Texture t=TextureIO.newTexture(f, true);
			texture=t.getTextureObject(gl);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			File f=new File("tex01.jpg");
			Texture t=TextureIO.newTexture(f, true);
			texture1=t.getTextureObject(gl);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		gl.glViewport(0, 0, width, height);
		if(height==0)
			height=1;
		float aspect=(float)width/height;
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
				new p07("p07");
			}
		});
	}

}
