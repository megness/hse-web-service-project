<?
/*$content = "Index page contents";
$title = "HSE Shop --- Home Page";
include("views/page.php");
*/

require_once("smarty/libs/Smarty.class.php");
$smarty = new Smarty();

$smarty->setTemplateDir('templates');
$smarty->setCompileDir('cache/smarty_cache/templates_cache');
$smarty->setCacheDir('smarty/smarty_cache/main_cache');
$smarty->setConfigDir('smarty/configs');

$smarty->assign('name', 'Ned');
$smarty->display('header.tpl');
$smarty->display('index.tpl');
$smarty->display('footer.tpl');

?>
