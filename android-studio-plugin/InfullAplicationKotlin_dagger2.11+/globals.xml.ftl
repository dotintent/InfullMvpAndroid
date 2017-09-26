<?xml version="1.0"?>
<globals>
    <global id="relativePackage" value="${packageName}.${classToResource(applicationClass)}" />
    <global id="newFolder" value="${escapeXmlAttribute(srcOut)}/${classToResource(applicationClass)}" />

    <global id="moduleClass" value="${underscoreToCamelCase(classToResource(applicationClass))}Module" />
    <global id="componentClass" value="${underscoreToCamelCase(classToResource(applicationClass))}Component" />
</globals>
