#!/usr/bin/env python3
"""Markdown -> HTML -> PDF (via LibreOffice).

Usage: python3 build_pdf.py input.md output.pdf [title]
"""
import os
import shutil
import subprocess
import sys
import tempfile

import markdown

CSS = """
@page { size: A4; margin: 18mm 16mm 18mm 16mm; }
body {
  font-family: "Noto Sans CJK SC", "Source Han Sans SC", "Noto Sans CJK JP", sans-serif;
  font-size: 10.5pt; line-height: 1.55; color: #1a1a1a;
}
h1 { font-size: 19pt; margin: 0 0 6pt; color: #111; }
h2 { font-size: 14pt; margin: 16pt 0 6pt; border-bottom: 1px solid #ddd; padding-bottom: 3pt; }
h3 { font-size: 12pt; margin: 12pt 0 4pt; }
p { margin: 4pt 0; }
table { border-collapse: collapse; width: 100%; margin: 6pt 0; font-size: 9pt; }
th, td { border: 1px solid #bbb; padding: 4pt 5pt; vertical-align: top; }
th { background: #f0f0f0; font-weight: bold; }
code, pre {
  font-family: "Noto Sans Mono CJK SC", "DejaVu Sans Mono", monospace;
  font-size: 8.5pt;
}
pre { background: #f6f8fa; border: 1px solid #e1e4e8; padding: 6pt; white-space: pre-wrap; }
code { background: #f2f2f2; padding: 0 2pt; }
blockquote { color: #555; border-left: 3px solid #ccc; margin: 6pt 0; padding-left: 8pt; }
a { color: #0645ad; }
hr { border: none; border-top: 1px solid #ddd; margin: 10pt 0; }
ul, ol { margin: 4pt 0 4pt 16pt; }
li { margin: 2pt 0; }
"""


def build(md_path: str, pdf_path: str, title: str | None = None) -> None:
    text = open(md_path, encoding="utf-8").read()
    html_body = markdown.markdown(
        text, extensions=["tables", "fenced_code", "toc", "sane_lists"]
    )
    html = f"""<!doctype html>
<html lang="zh-CN"><head><meta charset="utf-8">
<title>{title or os.path.basename(md_path)}</title>
<style>{CSS}</style></head>
<body>{html_body}</body></html>"""

    with tempfile.TemporaryDirectory() as td:
        html_path = os.path.join(td, "doc.html")
        open(html_path, "w", encoding="utf-8").write(html)
        profile = os.path.join(td, "lo_profile")
        cmd = [
            "soffice",
            f"-env:UserInstallation=file://{profile}",
            "--headless",
            "--convert-to",
            "pdf:writer_pdf_Export",
            "--outdir",
            td,
            html_path,
        ]
        subprocess.run(cmd, check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        produced = os.path.join(td, "doc.pdf")
        if not os.path.exists(produced):
            raise RuntimeError("PDF not produced")
        os.makedirs(os.path.dirname(os.path.abspath(pdf_path)) or ".", exist_ok=True)
        shutil.move(produced, pdf_path)
    print(f"{md_path} -> {pdf_path}")


if __name__ == "__main__":
    if len(sys.argv) < 3:
        print(__doc__)
        sys.exit(1)
    build(sys.argv[1], sys.argv[2], sys.argv[3] if len(sys.argv) > 3 else None)
