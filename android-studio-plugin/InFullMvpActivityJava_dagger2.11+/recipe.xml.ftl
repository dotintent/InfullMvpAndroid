<?xml version="1.0"?>
<recipe>

    <merge from="root/AndroidManifest.xml.ftl"
           to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <instantiate from="root/res/layout/activity.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

    <instantiate from="root/src/mvp_folder/Activity.java.ftl"
                 to="${newFolder}/${activityClass}.java" />
    <open file="${newFolder}/${activityClass}.java" />

    <instantiate from="root/src/mvp_folder/View.java.ftl"
                 to="${newFolder}/${viewClass}.java" />
    <open file="${newFolder}/${viewClass}.java" />

    <instantiate from="root/src/mvp_folder/Model.java.ftl"
                 to="${newFolder}/${modelClass}.java" />
    <open file="${newFolder}/${modelClass}.java" />

    <instantiate from="root/src/mvp_folder/Presenter.java.ftl"
                 to="${newFolder}/${presenterClass}.java" />
    <open file="${newFolder}/${presenterClass}.java" />

    <instantiate from="root/src/mvp_folder/di/ComponentClass.java.ftl"
                 to="${newFolder}/di/${componentClass}.java" />

    <instantiate from="root/src/mvp_folder/di/Scope.java.ftl"
                 to="${newFolder}/di/${scopeClass}.java" />

    <instantiate from="root/src/mvp_folder/di/Module.java.ftl"
                 to="${newFolder}/di/${moduleClass}.java" />

</recipe>
