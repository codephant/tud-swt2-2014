<?xml version="1.0" encoding="utf-8"?>
<!--
 ! This stylesheet converts a simple XHTML document into LaTeX.
 ! Beware that it does not support full XHTML and only uses essential markup:
 ! * h1..3
 ! * p
 ! * ul, ol
 ! * strong, em, b, i
 !-->
<t:stylesheet
    version="1.0"
    xmlns:t="http://www.w3.org/1999/XSL/Transform"
    xmlns:h="http://www.w3.org/1999/xhtml">
<t:output method="text" encoding="utf-8"/>
<t:strip-space elements="*"/>

<!--
 ! The root template selects the HTML body for further processing.
 !-->
<t:template match="/">
  <t:apply-templates select="/h:html/h:body/*" />
</t:template>

<!--
 ! First level heading corresponds to chapter.
 !-->
<t:template match="h:h1">
  <t:text>\section{</t:text>
  <t:apply-templates />
  <t:text>}

</t:text>
</t:template>

<!--
 ! Second level heading corresponds to section.
 !-->
<t:template match="h:h2">
  <t:text>\subsection{</t:text>
  <t:apply-templates />
  <t:text>}

</t:text>
</t:template>

<!--
 ! Third level heading corresponds to subsection.
 !-->
<t:template match="h:h3">
  <t:text>\subsubsection{</t:text>
  <t:apply-templates />
  <t:text>}

</t:text>
</t:template>

<!--
 ! Paragraphs are indicated by empty line, not by \par.
 !-->
<t:template match="h:p">
  <t:apply-templates />
  <t:text>

</t:text>
</t:template>

<!--
 ! Strong and Bold are both converted to \bf.
 !-->
<t:template match="h:b|h:strong">
  <t:text>\textbf{</t:text>
  <t:apply-templates />
  <t:text>}</t:text>
</t:template>

<!--
 ! !NO DOC 
 !-->
<t:template match="h:i">
  <t:text>\textit{</t:text>
  <t:apply-templates />
  <t:text>}</t:text>
</t:template>

<!--
 ! !NO DOC
 !-->
<t:template match="h:em">
  <t:text>\emph{</t:text>
  <t:apply-templates />
  <t:text>}</t:text>
</t:template>

<!--
 ! !NO DOC
 !-->
<t:template match="h:ul">
  <t:text>\begin{itemize}
</t:text>
  <t:apply-templates select="h:li"/>
  <t:text>\end{itemize}
</t:text>
</t:template>

<!--
 ! !NO DOC
 !-->
<t:template match="h:ol">
  <t:text>\begin{enumerate}
</t:text>
  <t:apply-templates select="h:li"/>
  <t:text>\end{enumerate}
</t:text>
</t:template>

<!--
 ! !NO DOC
 !-->
<t:template match="h:li">
  <t:text>\item </t:text>
  <t:apply-templates />
  <t:text>
</t:text>
</t:template>

<!--
 ! Do nothing for unknown elements, but outputting their text.
 !-->
<t:template match="*">
  <t:apply-templates />
</t:template>

</t:stylesheet>
