
import com.jogamp.opengl.GL2;

public class Ostroslup {
	public static void Draw(GL2 gl,double r,double h,int n,int m){
		double alpha,rr;
		double kat=Math.atan(r/h);

		for(int i=0;i<n;i++){
			gl.glPushAttrib(GL2.GL_CURRENT_BIT);
			if(i%2==0) gl.glColor3f(0.0f,0.0f,0.0f);

			gl.glBegin(GL2.GL_TRIANGLES);
			alpha=2.0*Math.PI*(-0.5+i)/n;
			rr=r/(m-1);
			gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.cos(alpha)*Math.sin(kat));
			gl.glVertex3d(0,h,0);

			alpha=2.0*Math.PI*i/n;
			gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.cos(alpha)*Math.sin(kat));
			gl.glVertex3d(rr*Math.cos(alpha),h-h/(m-1),rr*Math.sin(alpha));

			alpha=2.0*Math.PI*(i-1)/n;
			gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.cos(alpha)*Math.sin(kat));
			gl.glVertex3d(rr*Math.cos(alpha),h-h/(m-1),rr*Math.sin(alpha));
			gl.glEnd();
			gl.glPopAttrib();
		}

		for(int j=2;j<m;j++)
			for(int i=0;i<n;i++){

				gl.glPushAttrib(GL2.GL_CURRENT_BIT);
				if((i+j+1)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
				gl.glBegin(GL2.GL_QUADS);
				alpha=2.0*Math.PI*i/n;
				rr=r*j/(m-1);
				gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.sin(alpha)*Math.sin(kat));
				gl.glVertex3d(rr*Math.cos(alpha),h-h*j/(m-1),rr*Math.sin(alpha));

				alpha=2.0*Math.PI*(i-1)/n;
				rr=r*j/(m-1);
				gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.sin(alpha)*Math.sin(kat));
				gl.glVertex3d(rr*Math.cos(alpha),h-h*j/(m-1),rr*Math.sin(alpha));

				alpha=2.0*Math.PI*(i-1)/n;
				rr=r*(j-1)/(m-1);
				gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.sin(alpha)*Math.sin(kat));
				gl.glVertex3d(rr*Math.cos(alpha),h-h*(j-1)/(m-1),rr*Math.sin(alpha));

				alpha=2.0*Math.PI*i/n;
				rr=r*(j-1)/(m-1);
				gl.glNormal3d(Math.cos(alpha)*Math.sin(kat),Math.cos(kat),Math.sin(alpha)*Math.sin(kat));
				gl.glVertex3d(rr*Math.cos(alpha),h-h*(j-1)/(m-1),rr*Math.sin(alpha));
				gl.glEnd();
				gl.glPopAttrib();
			}

	}
}
