
import com.jogamp.opengl.GL2;

public class Walec {
	public static void Draw(GL2 gl,double r,double h,int n,int m){

		for(int i=0;i<m-1;i++)
			for(int j=0;j<n;j++){
				gl.glNormal3d(Math.cos(2.0*Math.PI*j/n),0,Math.sin(2.0*Math.PI*j/n));  
				gl.glPushAttrib(GL2.GL_CURRENT_BIT);
				if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
				gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3d(r*Math.cos(2.0*Math.PI*j/n),-h/2+h*i/(m-1),r*Math.sin(2.0*Math.PI*j/n));
				gl.glNormal3d(Math.cos(2.0*Math.PI*j/n),0,Math.sin(2.0*Math.PI*j/n));
				gl.glVertex3d(r*Math.cos(2.0*Math.PI*j/n),-h/2+h*(i+1)/(m-1),r*Math.sin(2.0*Math.PI*j/n));
				gl.glNormal3d(Math.cos(2.0*Math.PI*(j+1)/n),0,Math.sin(2.0*Math.PI*(j+1)/n));
				gl.glVertex3d(r*Math.cos(2.0*Math.PI*(j+1)/n),-h/2+h*(i+1)/(m-1),r*Math.sin(2.0*Math.PI*(j+1)/n));
				gl.glNormal3d(Math.cos(2.0*Math.PI*(j+1)/n),0,Math.sin(2.0*Math.PI*(j+1)/n));
				gl.glVertex3d(r*Math.cos(2.0*Math.PI*(j+1)/n),-h/2+h*i/(m-1),r*Math.sin(2.0*Math.PI*(j+1)/n));
				gl.glEnd();
				gl.glPopAttrib();
			}
	}
}
