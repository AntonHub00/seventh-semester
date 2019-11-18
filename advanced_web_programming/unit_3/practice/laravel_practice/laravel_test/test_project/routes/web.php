<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

// Route::get('usuarios/{id?}', function ($id="INVITADO") {
//     return "desde usuarios ".$id;
// })->name('usuarios');

Route::get('menu', function ($id="INVITADO") {
    // return '<a href="'.route("usuarios").'">Usuarios<a>';
    // return '<a href="">Usuarios<a>';
    $the_route = route('usuarios');
    return "<a href=\"{$the_route}\">Usuarios<a>";
})->name('usuarios');

Route::get('user/{id?}', function ($id="INVITADO") {
    return "User:{$id}";
})->name('usuarios')->where('id', '[0-9]*');

Route::get('contacto', 'TaskController@index')->middleware('example');