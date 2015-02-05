<%@ page language="java" import="java.util.*"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admin</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/uniform.default.css">
    <link rel="stylesheet" href="../css/jquery.fileupload.css">
    <style type="text/css">
        #province {
            width: 80px;
            margin-left: 10px;
        }

        .content {
            padding: 20px 200px 100px 200px;
        }

        .table th, .table td {
            text-align: center;
        }
        .fileinput-button {
            float: right;
        }
    </style>
</head>
<body>
<div class="topbar">
    <div class="container-fluid">
        <a href="/dashboard" class='company'>Admin</a>
        <ul class='mini'>
            <li>
                <a href="#"> <img src="../img/icons/fugue/gear.png" alt="">
                    Settings </a>
            </li>
            <li>
                <a href="/logout"> <img
                        src="../img/icons/fugue/control-power.png" alt=""> Logout
                </a>
            </li>
        </ul>
    </div>
</div>
<div class="breadcrumbs">
    <div class="container-fluid">
    </div>
</div>
<div class="main">
    <div class="container-fluid">
        <div class="navi" style="display:none">
            <ul class='main-nav'>
                <li>
                    <a href="/dashboard" class='light'>
                        <div class="ico">
                            <i class="icon-home icon-white"></i>
                        </div>
                        Dashboard </a>
                </li>
                <li>
                    <a href="/server" class='light'>
                        <div class="ico">
                            <i class="icon-list icon-white"></i>
                        </div>
                        Server </a>
                </li>
                <li class='active'>
                    <a href="#" class='light toggle-collapsed'>
                        <div class="ico"><i class="icon-th-large icon-white"></i></div>
                        Search
                        <img src="../img/toggle-subnav-down.png" alt="">
                    </a>
                    <ul class='collapsed-nav'>
                        <li>
                            <a href="/info_query">
                                搜索公司
                            </a>
                        </li>
                        <li>
                            <a href="/online">
                                在线查询
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/log" class='light'>
                        <div class="ico">
                            <i class="icon-book icon-white"></i>
                        </div>
                        Log </a>
                </li>
                <li>
                    <a href="#" class='light toggle-collapsed'>
                        <div class="ico"><i class="icon-th-large icon-white"></i></div>
                        Statistics
                        <img src="../img/toggle-subnav-down.png" alt="">
                    </a>
                    <ul class='collapsed-nav closed'>
                        <li>
                            <a href="/statistics">
                                月报表
                            </a>
                        </li>
                        <li>
                            <a href="/condition">
                                服务器监控
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="content">
            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-head">
                            <h3>
                                全国企业信息在线查询
                            </h3>
                        </div>
                        <div class="box-content">
                            <form class="form-horizontal">
                                <div class="control-group">
                                    <label for="corpName" class="control-label">单条查询</label>

                                    <div class="controls">
                                        <input type="text" name="corpName" placeholder="公司名字" id="corpName"
                                               class='input-square'>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" name="regCode" placeholder="注册号" id="regCode"
                                               class='input-square'>
                                        <select name="province" id="province">
                                            <option value="110000">北京</option>
                                            <option value="120000">天津</option>
                                            <option value="130000">河北</option>
                                            <option value="140000">山西</option>
                                            <option value="150000">内蒙古</option>
                                            <option value="210000">辽宁</option>
                                            <option value="220000">吉林</option>
                                            <option value="230000">黑龙江</option>
                                            <option value="310000">上海</option>
                                            <option value="320000">江苏</option>
                                            <option value="330000">浙江</option>
                                            <option value="340000">安徽</option>
                                            <option value="350000">福建</option>
                                            <option value="360000">江西</option>
                                            <option value="370000">山东</option>
                                            <option value="410000">河南</option>
                                            <option value="420000">湖北</option>
                                            <option value="430000">湖南</option>
                                            <option value="440000">广东</option>
                                            <option value="450000">广西</option>
                                            <option value="460000">海南</option>
                                            <option value="500000">重庆</option>
                                            <option value="510000">四川</option>
                                            <option value="520000">贵州</option>
                                            <option value="530000">云南</option>
                                            <option value="540000">西藏</option>
                                            <option value="610000">陕西</option>
                                            <option value="620000">甘肃</option>
                                            <option value="630000">青海</option>
                                            <option value="640000">宁夏</option>
                                            <option value="650000">新疆</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <input type="button" id="btn-submit" class='btn btn-primary' value="查询">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-fluid" id="singleres">
                <div class="span12">
                    <div class="box">
                        <div class="box-head">
                            <h3>
                                企业信息查询结果
                            </h3>
                        </div>
                        <div class="box-content">
                            <form class="form-horizontal">
                                <div class="control-group">
                                    <label class="control-label">
                                        XML信息
                                    </label>

                                    <div class="controls">
                                        <table id="singletable">

                                        </table>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-fluid" id="mulres">
                <div class="span12">
                    <div class="box">
                        <div class="box-head">
                            <h3>
                                批量结果
                            </h3>
                            <span class="btn btn-success fileinput-button">
                                <span>导入Excel</span>
                                <input id="fileupload" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"
                                       type="file" name="files[]" multiple>
                            </span>
                        </div>
                        <div class="box-content box-nomargin">
                            <table id="batchTable"
                                    class='table table-striped table-bordered'>
                                <thead>
                                <tr>
                                    <th>
                                        批量文件名
                                    </th>
                                    <th>
                                        状态
                                    </th>
                                    <th>
                                        提交时间
                                    </th>
                                    <th>
                                        完成时间
                                    </th>
                                    <th>
                                        下载
                                    </th>
                                </tr>
                                </thead>
                                <tbody id="batch">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../js/base/jquery.js"></script>
<script src="../js/base/bootstrap.min.js"></script>
<script src="../js/jquery.uniform.min.js"></script>
<script src="../js/custom.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/jquery.dataTables.bootstrap.js"></script>
<script src="../js/tableTools/js/TableTools.min.js"></script>
<script src="../js/jquery.blockUI.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="../js/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="../js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="../js/jquery.fileupload.js"></script>
<script type="text/javascript">

    $(document).ready(function() {
        var opt = {
            "sPaginationType": "bootstrap",
            "oLanguage":{
                "sSearch": "",
                "sLengthMenu": "Limit: _MENU_"
            },
            "bFilter": false,
            "bLengthChange": false,
            "ordering": false,
            "ajax": "/query/api/batch",
            "bDestroy": true,
            "columns": [
                { "data": "batchFilename" },
                { "data": "batchStatus" },
                { "data": "batchStime" },
                { "data": "batchEtime" },
                { "data": "batchUrl" }
            ]
        };
        var table = $('#batchTable').dataTable(opt);
        setInterval( function () {
            table.api().ajax.reload();
        }, 30000 );

        var url = '/file/api/upload';
        $('#fileupload').fileupload({
            url: url,
            dataType: 'json',
            done: function (e, data) {
//                console.log(data.result);
                type = data.result.status;
                if (type == 1) {
                    table.api().ajax.reload();
                    alert("上传成功");
                } else if (type == -1) {
                    alert("文件类型不支持");
                } else {
                    alert("上传失败");
                }
            }
        }).prop('disabled', !$.support.fileInput).parent().addClass(
                $.support.fileInput ? undefined : 'disabled');
    });

    $("#btn-submit").click(function () {
        corpName = $('#corpName').val();
        province = $('#province').val();
        regCode = $('#regCode').val();
        if (corpName == '' && regCode == '') {
            alert("公司名字和注册号不能全为空");
            return;
        } else {
            $.blockUI({
                css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .5,
                    color: '#fff'
                }
            });
            var post_data = {
                corpName: corpName,
                regCode: regCode,
                province: province
            };
            $.ajax({
                type: 'POST',
                url: "/query/api/single",
                dataType: "text",
                data: post_data,
                success: function (data) {
                    $.unblockUI();
                    console.log(data);
                    $('#singletable').html(data);
                }
            });
        }
    });

</script>
</body>
</html>