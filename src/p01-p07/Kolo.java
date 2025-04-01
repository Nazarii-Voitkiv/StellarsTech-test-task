
import com.jogamp.opengl.GL2;

public class Kolo {
	public static void Draw(GL2 gl,double r,int n,int m){

		double alpha,rr;
		gl.glNormal3d(0.0,1.0,0.0);
		for(int i=0;i<n;i++){
			gl.glPushAttrib(GL2.GL_CURRENT_BIT);
			if(i%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
			gl.glBegin(GL2.GL_TRIANGLES);
			gl.glVertex3d(0,0,0);
			alpha=2.0*Math.PI*i/n;
			rr=r/(m-1);
			gl.glVertex3d(rr*Math.cos(alpha),0,rr*Math.sin(alpha));
			alpha=2.0*Math.PI*(i-1)/n;
			rr=r/(m-1);
			gl.glVertex3d(rr*Math.cos(alpha),0,rr*Math.sin(alpha));
			gl.glEnd();
			gl.glPopAttrib();
		}
		for(int j=2;j<m;j++){
			for(int i=0;i<n;i++){
				gl.glPushAttrib(GL2.GL_CURRENT_BIT);
				if((i+j+1)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
				gl.glBegin(GL2.GL_QUADS);
				rr=r*j/(m-1);
				alpha=2.0*Math.PI*i/n;
				gl.glVertex3d(rr*Math.cos(alpha),0,rr*Math.sin(alpha));
				rr=r*j/(m-1);
				alpha=2.0*Math.PI*(i-1)/n;
				gl.glVertex3d(rr*Math.cos(alpha),0,rr*Math.sin(alpha));
				rr=r*(j-1)/(m-1);
				alpha=2.0*Math.PI*(i-1)/n;
				gl.glVertex3d(rr*Math.cos(alpha),0,rr*Math.sin(alpha));
				rr=r*(j-1)/(m-1);
				alpha=2.0*Math.PI*i/n;
				gl.glVertex3d(rr*Math.cos(alpha),0,rr*Math.sin(alpha));
				gl.glEnd();
				gl.glPopAttrib();
			}
		}

	}
}
