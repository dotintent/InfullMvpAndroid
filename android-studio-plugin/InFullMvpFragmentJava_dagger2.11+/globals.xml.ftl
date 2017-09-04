<?xml version="1.0"?>
<globals>
    <global id="relativePackage" value="${packageName}.${classToResource(fragmentClass)}" />
    <global id="newFolder" value="${escapeXmlAttribute(srcOut)}/${classToResource(fragmentClass)}" />

    <global id="scopeClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Scope" />
    <global id="moduleClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Module" />
    <global id="componentClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Component" />

    <global id="viewClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}View" />
    <global id="modelClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Model" />
    <global id="presenterClass" value="${underscoreToCamelCase(classToResource(fragmentClass))}Presenter" />
</globals>
