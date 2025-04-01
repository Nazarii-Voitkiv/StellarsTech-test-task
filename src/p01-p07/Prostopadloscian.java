
import com.jogamp.opengl.GL2;

public class Prostopadloscian {
	public static void Draw(GL2 gl,float a,float b,float h,int n,int m,int p){

		for(int k=0;k<2;k++){
			for(int i=0;i<m-1;i++)
				for(int j=0;j<n-1;j++){
					gl.glNormal3f(0,-1,0);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
					
					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					gl.glVertex3f(-a/2+a*j/(n-1),-h/2,-b/2+b*i/(m-1));
					gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2,-b/2+b*i/(m-1));
					gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2,-b/2+b*(i+1)/(m-1));
					gl.glVertex3f(-a/2+a*j/(n-1),-h/2,-b/2+b*(i+1)/(m-1));
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,0,1);
		}
		for(int k=0;k<2;k++){
			for(int i=0;i<p-1;i++)
				for(int j=0;j<n-1;j++){
					gl.glNormal3f(0,0,1);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					gl.glVertex3f(-a/2+a*j/(n-1),-h/2+h*i/(p-1),b/2);
					gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2+h*i/(p-1),b/2);
					gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2+h*(i+1)/(p-1),b/2);
					gl.glVertex3f(-a/2+a*j/(n-1),-h/2+h*(i+1)/(p-1),b/2);
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,1,0);
		}
		for(int k=0;k<2;k++){
			for(int i=0;i<m-1;i++)
				for(int j=0;j<p-1;j++){
					gl.glNormal3f(1,0,0);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					gl.glVertex3f(a/2,-h/2+h*j/(p-1),-b/2+b*i/(m-1));
					gl.glVertex3f(a/2,-h/2+h*(j+1)/(p-1),-b/2+b*i/(m-1));
					gl.glVertex3f(a/2,-h/2+h*(j+1)/(p-1),-b/2+b*(i+1)/(m-1));
					gl.glVertex3f(a/2,-h/2+h*j/(p-1),-b/2+b*(i+1)/(m-1));
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,0,1);
		}

	}
}
