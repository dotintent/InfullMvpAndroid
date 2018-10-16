<?xml version="1.0"?>
<globals>
    <global id="relativePackage" value="${packageName}.${classToResource(activityClass)}" />
    <global id="newFolder" value="${escapeXmlAttribute(srcOut)}/${classToResource(activityClass)}" />

    <global id="moduleName" value="${classToResource(activityClass)}Module" />
    <global id="moduleFileName" value="${underscoreToCamelCase(classToResource(activityClass))}Module" />
    <global id="scopeName" value="${classToResource(activityClass)}Scope" />

    <global id="viewClass" value="${underscoreToCamelCase(classToResource(activityClass))}View" />
    <global id="modelClass" value="${underscoreToCamelCase(classToResource(activityClass))}Model" />
    <global id="presenterClass" value="${underscoreToCamelCase(classToResource(activityClass))}Presenter" />
</globals>
