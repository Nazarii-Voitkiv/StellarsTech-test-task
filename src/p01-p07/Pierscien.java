
import com.jogamp.opengl.GL2;

public class Pierscien {
	public static void Draw(GL2 gl,double r1,double r2,int n,int m){
		double alpha,beta,xs,ys,zs;

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				gl.glPushAttrib(GL2.GL_CURRENT_BIT);
				if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
				gl.glBegin(GL2.GL_QUADS);
				alpha=2.0*Math.PI*i/n;
				beta=2.0*Math.PI*j/m;
				xs=r1*Math.cos(alpha);
				ys=0;
				zs=r1*Math.sin(alpha);
				gl.glNormal3d(Math.sin(beta)*Math.cos(alpha),Math.cos(beta),Math.sin(beta)*Math.sin(alpha));
				gl.glVertex3d(xs+r2*Math.sin(beta)*Math.cos(alpha),ys+r2*Math.cos(beta),zs+r2*Math.sin(beta)*Math.sin(alpha));

				alpha=2.0*Math.PI*(i-1)/n;
				beta=2.0*Math.PI*j/m;
				xs=r1*Math.cos(alpha);
				ys=0;
				zs=r1*Math.sin(alpha);
				gl.glNormal3d(Math.sin(beta)*Math.cos(alpha),Math.cos(beta),Math.sin(beta)*Math.sin(alpha));
				gl.glVertex3d(xs+r2*Math.sin(beta)*Math.cos(alpha),ys+r2*Math.cos(beta),zs+r2*Math.sin(beta)*Math.sin(alpha));

				alpha=2.0*Math.PI*(i-1)/n;
				beta=2.0*Math.PI*(j-1)/m;
				xs=r1*Math.cos(alpha);
				ys=0;
				zs=r1*Math.sin(alpha);
				gl.glNormal3d(Math.sin(beta)*Math.cos(alpha),Math.cos(beta),Math.sin(beta)*Math.sin(alpha));
				gl.glVertex3d(xs+r2*Math.sin(beta)*Math.cos(alpha),ys+r2*Math.cos(beta),zs+r2*Math.sin(beta)*Math.sin(alpha));

				alpha=2.0*Math.PI*i/n;
				beta=2.0*Math.PI*(j-1)/m;
				xs=r1*Math.cos(alpha);
				ys=0;
				zs=r1*Math.sin(alpha);
				gl.glNormal3d(Math.sin(beta)*Math.cos(alpha),Math.cos(beta),Math.sin(beta)*Math.sin(alpha));
				gl.glVertex3d(xs+r2*Math.sin(beta)*Math.cos(alpha),ys+r2*Math.cos(beta),zs+r2*Math.sin(beta)*Math.sin(alpha));

				gl.glEnd();
				gl.glPopAttrib();
			}
		}

	}
}
