*** Settings ***

Documentation     A test for ActiveMQ use case
...
...               This test creates a file in folder IN and expects to find
...               the result in forlder OUT.

Library           CamelTest.py


*** Variables ***

${BASEPATH} =            /Users/albertorobles/IdeaProjects/camel101/src/main/resources


*** Test Cases ***

New File Test Case
    [Documentation]     Created by Alro
    new file with text "sample text"
    copy under "${BASEPATH}/IN"
    queue wait process content  5
    check result "${BASEPATH}/OUT"


*** Keywords ***

new file with text "${texto}"
    Log     Got Argument ${texto}
    new file    ${texto}

copy under "${pathin}"
    Log     Got path IN ${pathin}
    create  ${pathin}

queue wait process content
    [Arguments]     ${seconds}=5
    Log     Got seconds ${seconds}
    queue wait  ${seconds}

check result "${pathout}"
    Log     Got path OUT ${pathout}
    check   ${pathout}



