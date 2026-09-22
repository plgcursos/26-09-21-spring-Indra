package es.cursospring.spring.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaMundoController {

	// Atiende el método GET de Http en /hola
	@GetMapping({"/hola", "/saludo", "/mentira.html"})
	@ResponseBody
	public String holaMundo() {
		return 
			"""
			<!DOCTYPE html>
			<html lang="en">
			<head>
				<meta charset="utf-8" />
				<meta name="viewport" content="width=device-width, initial-scale=1" />
				<title>Untitled Document</title>
				<style>
					body { font-family: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial; margin: 2rem; }
					header { margin-bottom: 1.5rem; }
					main { max-width: 800px; }
					pre { background:#f5f5f5; padding:1rem; border-radius:6px; overflow:auto }
				</style>
			</head>
			<body>
				<header>
					<h1>Hola Mundo</h1>
					<p>A minimal HTML template.</p>
				</header>
				<main>
					<section>
						<h2>Example</h2>
						<p>This is a starting point for your HTML document.</p>
						<pre><code>&lt;!-- Add your HTML here --&gt;</code></pre>
					</section>
				</main>
			</body>
			</html>

			""";
	}
}
