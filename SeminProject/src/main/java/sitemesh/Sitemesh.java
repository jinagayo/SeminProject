
package sitemesh;
import javax.servlet.annotation.WebFilter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

@WebFilter("/*")
public class Sitemesh extends ConfigurableSiteMeshFilter{
   @Override
   protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
      builder.addDecoratorPath("/student/*", "/view/student/studentLayout.jsp")
      		.addDecoratorPath("/admin/*", "/view/admin/adminLayout.jsp")
      		.addDecoratorPath("/professor/*", "/view/professor/professorLayout.jsp")
      		.addDecoratorPath("/board/*", "/view/board/boardlayout.jsp")
      		.addExcludedPath("/professor/professor-Ckpersonality")
            .addExcludedPath("/professor/professor-CkAtt")
            .addExcludedPath("/professor/professor-InGrade")
            .addExcludedPath("/professor/professor-subject-board")
            .addExcludedPath("/professor/professor-subject-QA-board")
            .addExcludedPath("/professor/professor-subject-board-info")
            .addExcludedPath("/professor/professor-subject-board2")
            .addExcludedPath("/professor/pictureForm");
      
}
}

