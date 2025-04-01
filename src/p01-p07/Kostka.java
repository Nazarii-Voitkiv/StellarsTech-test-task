
import com.jogamp.opengl.GL2;

public class Kostka {
	public static void Draw(GL2 gl,float size,int n){
		for(int i=0;i<6;i++){
			for(int x=0;x<n;x++)
				for(int y=0;y<n;y++){
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
					if((x+y)%2==0) gl.glColor3f(0.0f, 0.0f, 0.0f);
					//else if(i%3==0) gl.glColor3f(1.0f, 0.0f, 0.0f);
					//else if(i%3==1) gl.glColor3f(0.0f, 1.0f, 0.0f);
					//else gl.glColor3f(0.0f, 0.0f, 1.0f);
					gl.glNormal3f(0.0f, 0.0f, 1.0f);
					gl.glBegin(GL2.GL_QUADS);
						gl.glVertex3f(-0.5f*size+size*x/n,-0.5f*size+size*y/n, 0.5f*size);
						gl.glVertex3f(-0.5f*size+size*(x+1)/n,-0.5f*size+size*y/n, 0.5f*size);
						gl.glVertex3f(-0.5f*size+size*(x+1)/n,-0.5f*size+size*(y+1)/n, 0.5f*size);
						gl.glVertex3f(-0.5f*size+size*x/n,-0.5f*size+size*(y+1)/n, 0.5f*size);
					gl.glEnd();
					gl.glPopAttrib();
				}
			if(i%2==0) gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
			else gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
		}
	}
}
