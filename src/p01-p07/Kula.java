
import com.jogamp.opengl.GL2;

public class Kula {
	public static void Draw(GL2 gl,double r,int n,int m){
		  double alpha,beta;
		  int i,j;
		  
		  for(beta=180.0/m,i=0;beta<=180.0;beta+=180.0/m,i++)
		    for(alpha=0.0,j=0;alpha<360.0;alpha+=360.0/n,j++){
		    	gl.glPushAttrib(GL2.GL_CURRENT_BIT);
		    	if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
		      gl.glBegin(GL2.GL_QUADS);
		        
		      gl.glNormal3d(Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.cos(Math.PI*alpha/180.0),
		    		  Math.cos(Math.PI*(beta-180.0/m)/180.0),
		    		  Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.sin(Math.PI*alpha/180.0));
		      gl.glVertex3d(r*Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.cos(Math.PI*alpha/180.0),
		    		  r*Math.cos(Math.PI*(beta-180.0/m)/180.0),
		    		  r*Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.sin(Math.PI*alpha/180.0));
		      gl.glNormal3d(Math.sin(Math.PI*beta/180.0)*Math.cos(Math.PI*alpha/180.0),
		    		  Math.cos(Math.PI*beta/180.0),
		    		  Math.sin(Math.PI*beta/180.0)*Math.sin(Math.PI*alpha/180.0));
		      gl.glVertex3d(r*Math.sin(Math.PI*beta/180.0)*Math.cos(Math.PI*alpha/180.0),
		    		  r*Math.cos(Math.PI*beta/180.0),
		    		  r*Math.sin(Math.PI*beta/180.0)*Math.sin(Math.PI*alpha/180.0));
		      gl.glNormal3d(Math.sin(Math.PI*beta/180.0)*Math.cos(Math.PI*(alpha-360.0/n)/180.0),
		    		  Math.cos(Math.PI*beta/180.0),
		    		  Math.sin(Math.PI*beta/180.0)*Math.sin(Math.PI*(alpha-360.0/n)/180.0));
		      gl.glVertex3d(r*Math.sin(Math.PI*beta/180.0)*Math.cos(Math.PI*(alpha-360.0/n)/180.0),
		    		  r*Math.cos(Math.PI*beta/180.0),
		    		  r*Math.sin(Math.PI*beta/180.0)*Math.sin(Math.PI*(alpha-360.0/n)/180.0));
		      gl.glNormal3d(Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.cos(Math.PI*(alpha-360.0/n)/180.0),
		    		  Math.cos(Math.PI*(beta-180.0/m)/180.0),
		    		  Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.sin(Math.PI*(alpha-360.0/n)/180.0));
		      gl.glVertex3d(r*Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.cos(Math.PI*(alpha-360.0/n)/180.0),
		    		  r*Math.cos(Math.PI*(beta-180.0/m)/180.0),
		    		  r*Math.sin(Math.PI*(beta-180.0/m)/180.0)*Math.sin(Math.PI*(alpha-360.0/n)/180.0));
		      gl.glEnd();
		      gl.glPopAttrib();
		    }
		}
}
