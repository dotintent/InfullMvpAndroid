<?xml version="1.0"?>
<globals>
    <global id="relativePackage" value="${packageName}.${classToResource(fragmentClass)}" />
    <global id="newFolder" value="${escapeXmlAttribute(srcOut)}/${classToResource(fragmentClass)}" />

    <global id="moduleName" value="${classToResource(fragmentClass)}Module" />
    <global id="moduleFileName" value="${underscoreToCamelCase(classToResource(fragmentClass))}Module" />
    <global id="scopeName" value="${classToResource(fragmentClass)}Scope" />

    <global id="viewClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}View" />
    <global id="modelClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Model" />
    <global id="presenterClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Presenter" />
</globals>
