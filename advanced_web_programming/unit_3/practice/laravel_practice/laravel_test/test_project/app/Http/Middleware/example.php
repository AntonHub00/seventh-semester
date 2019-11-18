<?php

namespace App\Http\Middleware;

use Closure;

class example
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
        if($request->name == 'hola'){
        return $next($request);
        }else{
            return response("Error", 404);
        }
    }
}
