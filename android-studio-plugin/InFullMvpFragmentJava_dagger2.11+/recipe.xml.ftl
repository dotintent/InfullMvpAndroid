<?xml version="1.0"?>
<recipe>

    <instantiate from="root/res/layout/fragment.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

    <instantiate from="root/src/mvp_folder/Fragment.java.ftl"
                 to="${newFolder}/${fragmentClass}.java" />
    <open file="${newFolder}/${fragmentClass}.java" />

    <instantiate from="root/src/mvp_folder/View.java.ftl"
                 to="${newFolder}/${viewClass}.java" />
    <open file="${newFolder}/${viewClass}.java" />

    <instantiate from="root/src/mvp_folder/Model.java.ftl"
                 to="${newFolder}/${modelClass}.java" />
    <open file="${newFolder}/${modelClass}.java" />

    <instantiate from="root/src/mvp_folder/Presenter.java.ftl"
                 to="${newFolder}/${presenterClass}.java" />
    <open file="${newFolder}/${presenterClass}.java" />

    <instantiate from="root/src/mvp_folder/di/Component.java.ftl"
                 to="${newFolder}/di/${componentClass}.java" />

    <instantiate from="root/src/mvp_folder/di/Scope.java.ftl"
                 to="${newFolder}/di/${scopeClass}.java" />

    <instantiate from="root/src/mvp_folder/di/Module.java.ftl"
                 to="${newFolder}/di/${moduleClass}.java" />

</recipe>
